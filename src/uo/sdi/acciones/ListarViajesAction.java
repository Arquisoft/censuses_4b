package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class ListarViajesAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Trip> viajes;
		List<Trip> viajesValidos = new ArrayList<Trip>();
		
		try {
			viajes=PersistenceFactory.newTripDao().findAll();
			Date hoy = new Date();
						
			for(int i = 0; i < viajes.size(); i++) {
				if(viajes.get(i).getClosingDate().after(hoy) &&
						viajes.get(i).getArrivalDate().after(hoy) &&
						viajes.get(i).getDepartureDate().after(hoy) &&
						viajes.get(i).getAvailablePax() > 0) {
					viajesValidos.add(viajes.get(i));
				}
			}
			
			request.setAttribute("listaViajes", viajesValidos);
			Log.debug("Obtenida lista de viajes conteniendo [%d] viajes", viajesValidos.size());
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		
		return "EXITO";
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
