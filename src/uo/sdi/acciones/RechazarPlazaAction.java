package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class RechazarPlazaAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	try {

	    Long idSolicitante = Long.parseLong(request
		    .getParameter("solicitante"));
	    User solicitante = PersistenceFactory.newUserDao().findById(
		    idSolicitante);

	    Long idTrip = Long.parseLong(request.getParameter("seat"));
	    Trip trip = PersistenceFactory.newTripDao().findById(idTrip);

	    Seat seat = PersistenceFactory.newSeatDao().findByUserAndTrip(
		    solicitante.getId(), trip.getId());

	    if (seat.getStatus().equals(SeatStatus.PENDIENTE)) {

		PersistenceFactory.newSeatDao().rechazarPlaza(trip.getId(),
			solicitante.getId());
	    } else if (seat.getStatus().equals(SeatStatus.ADMITIDO)) {

		PersistenceFactory.newSeatDao().rechazarPlaza(trip.getId(),
			solicitante.getId());

		int plazas = trip.getAvailablePax() + 1;
		trip.setAvailablePax(plazas);
		PersistenceFactory.newTripDao().update(trip);
	    }

	    else {
		request.setAttribute("plaza",
			"La plaza ya ha sido rechazada anteriormente");
		Log.info("Ya está rechazada");
		return "FRACASO";
	    }

	} catch (Exception e) {
	    request.setAttribute("plaza", "No se ha podido rechazar la plaza");
	    Log.error("No se ha podido rechazar la plaza");
	    return "FRACASO";
	}

	request.setAttribute("plaza", "Se ha rechazado con éxito la plaza");
	Log.info("Se ha rechazado con éxito la plaza");
	return "EXITO";
    }

}
