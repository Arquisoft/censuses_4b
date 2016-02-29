package uo.sdi.acciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;

public class CancelarViajeAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	String resultado = "";
	Trip trip;
	Seat seat;
	Long id = Long.parseLong(request.getParameter("id"));
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");

	trip = PersistenceFactory.newTripDao().findById(id);
	seat = PersistenceFactory.newSeatDao().findByUserAndTrip(user.getId(),
		id);

	request.setAttribute("trip", trip);
	Map<String, Map<String,User>> mapseat = new HashMap<String, Map<String,User>>();
	Seat seatmostrarViaje;

	try {

	    if (seat != null) {
		if (!trip.getPromoterId().equals(user.getId())) {
		    if (trip.getStatus().equals(TripStatus.OPEN)) {
			if (seat.getStatus().equals(SeatStatus.PENDIENTE)
				|| seat.getStatus().equals(SeatStatus.ACCEPTED)) {
			    
			    seat.setStatus(SeatStatus.EXCLUDED);
			    PersistenceFactory.newSeatDao().update(seat);

			    request.setAttribute(
				    "mensaje",
				    "Se ha cancelado la solicitud de plaza "
					    + "correctamente, actualmente está como "
					    + seat.getStatus());
			    Log.debug(
				    "El usuario [%s] ha cancelado la solicitud"
					    + " de plaza, y pasa a estar como excluído",
				    user.getLogin());

			    resultado= "EXITO";
			} else {
			    
			    request.setAttribute("mensaje",
				    "No puede cancelar la solicitud de plaza, "
				    + "porque no ha sido "
				    + "confirmado ni estaba como pendiente");
			    Log.error("El usuario [%s] no puede cancelar la "
				    + "solicitud de plaza, porque no ha sido "
				    + "confirmado ni estaba como pendiente",
				    user.getLogin());
			    resultado = "FRACASO";
			}
		    } else {
			request.setAttribute("mensaje",
				    "No puede cancelar la solicitud de plaza, "
				    + "porque el viaje ya no está abierto");
			Log.error(
				"El usuario [%s] no puede cancelar la solicitud"
					+ " de plaza, porque el viaje ya no está abierto",
				user.getLogin());
			resultado = "FRACASO";
		    }
		} else {
		    request.setAttribute("mensaje",
			    "No puede cancelar la solicitud de plaza, porque es "
				    + "el promotor del viaje");
		    Log.error(
			    "El usuario [%s] no puede cancelar la solicitud de plaza, "
				    + "porque es el promotor del viaje",
			    user.getLogin());
		    resultado = "FRACASO";
		}

	    } else {
		request.setAttribute("mensaje",
			"No puede cancelar la solicitud de plaza, porque"
				+ " no la ha solicitado");
		Log.error("El usuario [%s] no puede cancelar la solicitud de "
			+ "plaza, porque no la ha solicitado", user.getLogin());
		resultado = "FRACASO";
	    }
	    
	    
	    List<User> users = PersistenceFactory.newUserDao().findAll();
	    int contador=0;
		for (User u : users) {
		    seatmostrarViaje=null;
		    seatmostrarViaje = PersistenceFactory.newSeatDao()
			    .findByUserAndTrip(u.getId(), id);
		    if (seatmostrarViaje != null) {
			Map<String, User> m = new HashMap<String, User>();
			m.put(seatmostrarViaje.getStatus().toString(), u);
			mapseat.put(contador +"", m);
			contador++;
			
		    }
		}
		request.setAttribute("mapseat", mapseat);
	    
	} catch (Exception e) {
	    Log.error("Algo ha ocurrido cancelando la solicitud de plaza");
	    resultado = "FRACASO";
	}

	

	return resultado;

    }

    @Override
    public String toString() {
	return getClass().getName();
    }

}
