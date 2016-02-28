package uo.sdi.acciones;

import javax.servlet.http.*;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class MostrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Trip trip;
		User user;
		Long id = Long.parseLong(request.getParameter("id"));
					
		try {
			
			trip = PersistenceFactory.newTripDao().findById(id);
			user = PersistenceFactory.newUserDao().findById(trip.getPromoterId());
			request.setAttribute("trip", trip);
			request.setAttribute("user", user);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo el viaje");
			return "FRACASO";
		}
		
		return "EXITO";
	}

}
