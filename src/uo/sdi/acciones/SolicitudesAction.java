package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class SolicitudesAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	Map<String, Map<String, Trip>> mapViajes = new HashMap<String, Map<String, Trip>>();
	Map<String, Map<String, Trip>> mapViajesMnp = new HashMap<String, Map<String, Trip>>();
	int contador = 0;

	try {

	    List<Seat> seats = PersistenceFactory.newSeatDao().findAll();
	    List<Seat> solicitantes = new ArrayList<Seat>();
	    List<Seat> promotores = new ArrayList<Seat>();
	    List<String> logins = new ArrayList<String>();
	    List<String> usuarios = new ArrayList<String>();

	    for (Seat seat : seats) {

		Trip trip = PersistenceFactory.newTripDao().findById(
			seat.getTripId());

		if (user.getId().equals(trip.getPromoterId())
			&& !seat.getStatus().equals(SeatStatus.PROMOTOR)) {
		    // EL usuario es promotor de viajes
		    Map<String, Trip> m = new HashMap<String, Trip>();
		    m.put(seat.getStatus().toString(), trip);
		    mapViajes.put(contador + "", m);
		    solicitantes.add(seat);
		    User p = PersistenceFactory.newUserDao().findById(
			    seat.getUserId());
		    usuarios.add(p.getLogin());
		    contador++;
		}

		if (seat.getUserId().equals(user.getId())) {
		    Map<String, Trip> mnp = new HashMap<String, Trip>();
		    mnp.put(seat.getStatus().toString(), trip);
		    mapViajesMnp.put(contador + "", mnp);
		    promotores.add(seat);
		    User p = PersistenceFactory.newUserDao().findById(
			    trip.getPromoterId());
		    logins.add(p.getLogin());
		    contador++;
		}
	    }
	    if (mapViajes.size() > 0) {
		request.setAttribute("mapViajes", mapViajes);
		request.setAttribute("solicitante", solicitantes);
		request.setAttribute("usuarios", usuarios);
	    }
	    if (mapViajesMnp.size() > 0) {
		request.setAttribute("mapViajesMnp", mapViajesMnp);
		request.setAttribute("promotores", promotores);
		request.setAttribute("logins", logins);
	    }

	} catch (Exception e) {
	    Log.error("Algo ha ocurrido al mostrar los viajes");
	    return "FRACASO";
	}

	return "EXITO";
    }

}
