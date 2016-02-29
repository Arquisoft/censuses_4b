package uo.sdi.acciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import uo.sdi.model.Seat;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class MostrarMisViajesAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	Map<String, Map<String, Trip>> mapViajes = new HashMap<String, Map<String, Trip>>();
	int contador = 0;

	try {
	    List<Trip> trips = PersistenceFactory.newTripDao().findAll();

	    for (Trip trip : trips) {
		Seat seat = PersistenceFactory.newSeatDao().findByUserAndTrip(
			user.getId(), trip.getId());
		if (seat != null) {
		    Map<String, Trip> m = new HashMap<String, Trip>();
		    m.put(seat.getStatus().toString(), trip);
		    mapViajes.put(contador + "", m);
		    contador++;
		}
	    }

	    request.setAttribute("mapViajes", mapViajes);

	} catch (Exception e) {
	    Log.error("Algo ha ocurrido obteniendo el viaje");
	    return "FRACASO";
	}

	return "EXITO";
    }

}
