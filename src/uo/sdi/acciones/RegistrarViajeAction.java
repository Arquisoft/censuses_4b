package uo.sdi.acciones;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.*;

import uo.sdi.model.*;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class RegistrarViajeAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	String resultado = "";
	HttpSession session = request.getSession();

	if (!comprobarCampos(request)) {
	    resultado = "FRACASO";
	    return resultado;
	}

	Date arrivalDate, departureDate, closingDate;

	try {

	    arrivalDate = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		    .parse(request.getParameter("fechaLlegada"));
	    departureDate = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		    .parse(request.getParameter("fechaSalida"));
	    closingDate = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		    .parse(request.getParameter("fechaLimite"));

	    if (!closingDate.before(departureDate)
		    || !departureDate.before(arrivalDate)) {
		request.setAttribute("mensajeViaje",
			"Las fechas introducidas tienen que tener orden cronológico");
		Log.debug("Las fechas introducidas tienen que tener orden cronológico");
		resultado = "FRACASO";
		return resultado;
	    }

	} catch (Exception e) {
	    request.setAttribute("mensajeViaje",
		    "Las fechas introducidas no tienen el formato correcto");
	    Log.debug("Las fechas introducidas no tienen el formato correcto");
	    resultado = "FRACASO";
	    return resultado;
	}

	User user = ((User) session.getAttribute("user"));

	Double latS = 0.0;
	Double lonS = 0.0;
	Double latLl = 0.0;
	Double lonLl = 0.0;

	if (!request.getParameter("latSalida").isEmpty()) {
	    latS = Double.parseDouble(request.getParameter("latSalida"));
	}
	if (!request.getParameter("lonSalida").isEmpty()) {
	    lonS = Double.parseDouble(request.getParameter("lonSalida"));
	}
	if (!request.getParameter("latLlegada").isEmpty()) {
	    latLl = Double.parseDouble(request.getParameter("latLlegada"));
	}
	if (!request.getParameter("lonLlegada").isEmpty()) {
	    lonLl = Double.parseDouble(request.getParameter("lonLlegada"));
	}

	Waypoint waypointSalida = new Waypoint(latS, lonS);
	Waypoint waypointLlegada = new Waypoint(latLl, lonLl);

	AddressPoint departure = new AddressPoint(
		request.getParameter("direccionSalida"),
		request.getParameter("ciudadSalida"),
		request.getParameter("provinciaSalida"),
		request.getParameter("paisSalida"),
		request.getParameter("CPSalida"), waypointSalida);

	AddressPoint destination = new AddressPoint(
		request.getParameter("direccionLlegada"),
		request.getParameter("ciudadLlegada"),
		request.getParameter("provinciaLlegada"),
		request.getParameter("paisLlegada"),
		request.getParameter("CPLlegada"), waypointLlegada);

	Trip trip = new Trip();
	trip.setArrivalDate(arrivalDate);
	trip.setAvailablePax(Integer.parseInt(request
		.getParameter("plazasLibres")));
	trip.setClosingDate(closingDate);
	trip.setComments(request.getParameter("comentarios"));
	trip.setDeparture(departure);
	trip.setDepartureDate(departureDate);
	trip.setDestination(destination);
	trip.setEstimatedCost(Double.parseDouble(request.getParameter("coste")));
	trip.setMaxPax(Integer.parseInt(request.getParameter("plazasTotal")));
	trip.setStatus(TripStatus.OPEN);
	trip.setPromoterId(user.getId());

	PersistenceFactory.newTripDao().save(trip);

	// busco de todos los viajes varios detalles porque no es suficiente
	// el id del promotor y la fecha de llegada.
	Long idViaje = null;
	for (Trip t : PersistenceFactory.newTripDao().findAll()) {
	    if (trip.getPromoterId().equals(t.getPromoterId())
		    && trip.getArrivalDate().equals(t.getArrivalDate())
		    && trip.getDeparture().equals(t.getDeparture())
		    && trip.getDestination().equals(t.getDestination())) {
		idViaje = t.getId();
	    }
	}

	Seat seat = new Seat();
	seat.setTripId(idViaje);
	seat.setStatus(SeatStatus.PROMOTOR);
	seat.setUserId(trip.getPromoterId());
	seat.setComment("");

	PersistenceFactory.newSeatDao().save(seat);

	request.setAttribute("mensajeViaje", "Se ha registrado un viaje: \n"
		+ trip.getDeparture().getCity() + "-"
		+ trip.getDestination().getCity() + "\n en "
		+ "el que el usuario " + user.getLogin() + " es el promotor");
	Log.info("Se ha registrado un viaje: \n" + trip.toString() + "\n en "
		+ "el que el usuario " + user.getLogin() + " es el promotor");

	resultado = "EXITO";
	Log.info("RESULTADO DEL REGISTRO:  " + resultado);
	return resultado;
    }

    private boolean comprobarCampos(HttpServletRequest request) {

	if (request.getParameter("direccionSalida").isEmpty()
		|| request.getParameter("ciudadSalida").isEmpty()
		|| request.getParameter("provinciaSalida").isEmpty()
		|| request.getParameter("paisSalida").isEmpty()
		|| request.getParameter("CPSalida").isEmpty()) {

	    request.setAttribute("mensajeViaje",
		    "Alguno de los campos relacionados con la salida no ha sido rellenado");
	    Log.debug("Alguno de los campos relacionados con la salida no ha sido rellenado");
	    return false;
	}

	if (request.getParameter("direccionLlegada").isEmpty()
		|| request.getParameter("ciudadLlegada").isEmpty()
		|| request.getParameter("provinciaLlegada").isEmpty()
		|| request.getParameter("paisLlegada").isEmpty()
		|| request.getParameter("CPLlegada").isEmpty()) {
	    request.setAttribute("mensajeViaje",
		    "Alguno de los campos relacionados con la llegada no ha sido rellenado");
	    Log.debug("Alguno de los campos relacionados con la llegada no ha sido rellenado");
	    return false;
	}

	if (request.getParameter("plazasLibres").isEmpty()
		|| Integer.parseInt(request.getParameter("plazasLibres")) < 0) {
	    request.setAttribute("mensajeViaje",
		    "Las plazas disponibles están vacías o no son correctas");
	    Log.debug("Las plazas disponibles están vacías o no son correctas");
	    return false;
	}

	if (request.getParameter("comentarios").isEmpty()) {
	    request.setAttribute("mensajeViaje",
		    "El campo de comentarios no ha sido rellenado");
	    Log.debug("El campo de comentarios no ha sido rellenado");
	    return false;
	}

	if (request.getParameter("coste").isEmpty()
		|| Integer.parseInt(request.getParameter("coste")) < 0) {
	    request.setAttribute("mensajeViaje",
		    "El campo de coste no ha sido rellenado o no es correcto");
	    Log.debug("El campo de coste no ha sido rellenado o no es correcto");
	    return false;
	}

	if (request.getParameter("plazasTotal").isEmpty()
		|| Integer.parseInt(request.getParameter("plazasTotal")) < 0) {
	    request.setAttribute("mensajeViaje",
		    "Las plazas máximas están vacías o no son correctas");
	    Log.debug("Las plazas máximas están vacías o no son correctas");
	    return false;
	}

	return true;
    }

}
