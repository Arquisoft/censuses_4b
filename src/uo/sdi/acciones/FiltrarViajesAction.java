package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.Date;
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

public class FiltrarViajesAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	
		String id = request.getParameter("id");
		String departure = request.getParameter("origen");
		String arrival = request.getParameter("destino");
		
		List<Trip> viajes;
		List<Trip> viajesValidos = new ArrayList<Trip>();
		
		try {
			viajes=PersistenceFactory.newTripDao().findAll();
						
			if(id.equals("historial")) {
				for(int i = 0; i < viajes.size(); i++) {
					if(viajes.get(i).getDeparture().getCity().equals(departure) &&
							viajes.get(i).getDestination().getCity().equals(arrival)) {
						viajesValidos.add(viajes.get(i));
					}
				}
			} else if(id.equals("lista")) {
				Date hoy = new Date();
				
				for(int i = 0; i < viajes.size(); i++) {
					if(viajes.get(i).getDeparture().getCity().equals(departure) &&
							viajes.get(i).getDestination().getCity().equals(arrival) &&
							viajes.get(i).getClosingDate().after(hoy) &&
							viajes.get(i).getArrivalDate().after(hoy) &&
							viajes.get(i).getDepartureDate().after(hoy) &&
							viajes.get(i).getAvailablePax() > 0) {
						viajesValidos.add(viajes.get(i));
					}
				}
			} else if(id.equals("misViajes")) {

				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				Map<String, Map<String, Trip>> mapViajes = new HashMap<String, Map<String, Trip>>();
				int contador = 0;
				int aux = 0;
				
			    for (Trip trip : viajes) {
			    	
			    	if(viajes.get(aux).getDeparture().getCity().equals(departure) &&
							viajes.get(aux).getDestination().getCity().equals(arrival)) {
			    		
			    		Seat seat = PersistenceFactory.newSeatDao().findByUserAndTrip(
							user.getId(), trip.getId());
						if (seat != null) {
						    Map<String, Trip> m = new HashMap<String, Trip>();
						    m.put(seat.getStatus().toString(), trip);
						    mapViajes.put(contador + "", m);
						    contador++;
						}
			    	}
			    	aux++;
			    }

			    request.setAttribute("mapViajes", mapViajes);
			} else if(id.equals("solicitudes")) {

				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				Map<String, Map<String, Trip>> mapViajes = new HashMap<String, Map<String, Trip>>();
				Map<String, Map<String, Trip>> mapViajesMnp = new HashMap<String, Map<String, Trip>>();
				int contador = 0;
				
				List<Seat> seats = PersistenceFactory.newSeatDao().findAll();
				List<Seat> solicitantes = new ArrayList<Seat>();
				List<Seat> promotores = new ArrayList<Seat>();
				
				for(Seat seat: seats) {
															
					Trip trip = PersistenceFactory.newTripDao().findById(seat.getTripId());
					
					if(trip.getDeparture().getCity().equals(departure) &&
						trip.getDestination().getCity().equals(arrival) &&
						user.getId().equals(trip.getPromoterId()) 
						&& !seat.getStatus().equals(SeatStatus.PROMOTOR)) {	// EL usuario es promotor de viajes
						
						Map<String, Trip> m = new HashMap<String, Trip>();
						m.put(seat.getStatus().toString(), trip);
						mapViajes.put(contador + "", m);
						
						solicitantes.add(seat);
						contador++;
					}
					
					if(trip.getDeparture().getCity().equals(departure) &&
						trip.getDestination().getCity().equals(arrival) &&
						seat.getUserId().equals(user.getId())) {
						
						Map<String, Trip> mnp = new HashMap<String, Trip>();
						mnp.put(seat.getStatus().toString(), trip);
						mapViajesMnp.put(contador + "", mnp);
						
						promotores.add(seat);
						contador++;
					}
				}

				if(mapViajes.size() > 0) {
					request.setAttribute("mapViajes", mapViajes);
					request.setAttribute("solicitante", solicitantes);
				}
				if(mapViajesMnp.size() > 0) {
					request.setAttribute("mapViajesMnp", mapViajesMnp);
					request.setAttribute("promotores", promotores);
				}
			}

			request.setAttribute("id", id);
			
			if(viajesValidos.size() > 0) {
				request.setAttribute("viajesValidos", viajesValidos);
				Log.debug("Obtenida lista de viajes conteniendo [%d] viajes filtrados ", viajesValidos.size());
			}
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes filtrados");
		}
		
		return "EXITO";
	}

}
