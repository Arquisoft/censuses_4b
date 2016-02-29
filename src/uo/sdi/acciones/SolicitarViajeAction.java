package uo.sdi.acciones;

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

public class SolicitarViajeAction implements Accion {

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

	try {

	    if (trip.getStatus().equals(TripStatus.OPEN)) {
		if (!trip.getPromoterId().equals(user.getId())) {
		    if (seat == null) {
			seat = new Seat();
			seat.setTripId(trip.getId());
			seat.setUserId(user.getId());
			seat.setStatus(SeatStatus.PENDIENTE);
			seat.setComment("");
			PersistenceFactory.newSeatDao().save(seat);
			request.setAttribute(
				"mensaje",
				"Se ha solicitado plaza correctamente, "
					+ "actualmente está como "
					+ seat.getStatus());
			Log.debug("El usuario [%s] ha solicitado plaza, "
				+ "y pasa a estar como pendiente",
				user.getLogin());

			resultado = "EXITO";

		    } else if (seat != null
			    && !seat.getStatus().equals(SeatStatus.PENDIENTE)
			    && !seat.getStatus().equals(SeatStatus.PROMOTOR)) {
			seat.setStatus(SeatStatus.PENDIENTE);
			PersistenceFactory.newSeatDao().update(seat);
			request.setAttribute(
				"mensaje",
				"Se ha solicitado plaza correctamente, "
					+ "actualmente está como "
					+ seat.getStatus());
			Log.debug("El usuario [%s] ha solicitado plaza, "
				+ "y pasa a estar como pendiente",
				user.getLogin());

			resultado = "EXITO";

		    } else {
			request.setAttribute("mensaje",
				"No puede solicitar plaza, porque ya "
					+ "la ha solicitado antes");
			Log.error("El usuario [%s] no puede solicitar plaza, "
				+ "porque ya la ha solicitado antes",
				user.getLogin());
			resultado = "FRACASO";
		    }

		} else {

		    request.setAttribute("mensaje",
			    "No puede solicitar plaza, porque es "
				    + "el promotor del viaje");
		    Log.error("El usuario [%s] no puede solicitar plaza, "
			    + "porque es el promotor del viaje",
			    user.getLogin());
		    resultado = "FRACASO";
		}
	    } else {
		Log.error("El usuario [%s] no puede solicitar la plaza,"
			+ " porque el viaje ya no está abierto",
			user.getLogin());
		resultado = "FRACASO";
	    }

	} catch (Exception e) {
	    Log.error("Algo ha ocurrido solicitando la plaza");
	    resultado = "FRACASO";
	}

	return resultado;

    }

    @Override
    public String toString() {
	return getClass().getName();
    }

}
