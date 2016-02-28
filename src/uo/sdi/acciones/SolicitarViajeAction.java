package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.model.Seat;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;


public class SolicitarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	    
	    	Trip trip;
	    	Seat seat;
		Long id = Long.parseLong(request.getParameter("id"));
					
		try {
		    	HttpSession session=request.getSession();
			trip = PersistenceFactory.newTripDao().findById(id);
			User user = (User) session.getAttribute("user");
			seat = PersistenceFactory.newSeatDao().findByUserAndTrip(user.getId(), id);	
			
			request.setAttribute("trip", trip);
			request.setAttribute("seat", seat);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo el viaje");
			return "FRACASO";
		}
		
		return "EXITO";
	}

	@Override
	public String toString() {
	    return getClass().getName();
	}

}
