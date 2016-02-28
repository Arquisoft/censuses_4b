package uo.sdi.acciones;

import javax.servlet.http.*;

import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class MostrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Trip trip;
		Long id = Long.parseLong(request.getParameter("id"));
					
		try {
			
			trip = PersistenceFactory.newTripDao().findById(id);
			request.setAttribute("trip", trip);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo el viaje");
			return "FRACASO";
		}
		
		return "EXITO";
	}

}
