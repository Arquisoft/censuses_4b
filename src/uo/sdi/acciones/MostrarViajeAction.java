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

public class MostrarViajeAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {
    	
	Trip trip;
	Seat seat;
	Long id = Long.parseLong(request.getParameter("id"));

	Map<String,Map<String, User>> mapseat = new HashMap<String, Map<String, User>>();

	try {

	    trip = PersistenceFactory.newTripDao().findById(id);
	    List<User> users = PersistenceFactory.newUserDao().findAll();
	    int contador=0;
	    for (User u : users) {
		seat=null;
		seat = PersistenceFactory.newSeatDao().findByUserAndTrip(
			u.getId(), id);
		if (seat != null) {
		    Map<String, User> m = new HashMap<String, User>();		    
		    m.put(seat.getStatus().toString(), u);
		    mapseat.put(contador +"", m);
		    contador++;
		}
	    }

	    request.setAttribute("mapseat", mapseat);
	    request.setAttribute("trip", trip);

	} catch (Exception e) {
	    Log.error("Algo ha ocurrido obteniendo el viaje");
	    return "FRACASO";
	}

	return "EXITO";
    }

}
