package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.model.*;
import uo.sdi.persistence.PersistenceFactory;

public class ComentarAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	
		Long idTrip = Long.parseLong(request.getParameter("id"));
		
		try {

			Trip trip = PersistenceFactory.newTripDao().findById(idTrip);
			
			Date hoy = new Date();
			
			if(hoy.before(trip.getArrivalDate())) {
				String mensaje = "No se puede comentar un viaje que todavía no ha acabado";
				Log.info(mensaje);
				request.setAttribute("mensaje", mensaje);
				return "FRACASO";
			}
			
			List <Seat> seats = PersistenceFactory.newSeatDao().findAll();
			List <Seat> seatsValidos = new ArrayList<Seat>();
			List <User> users = new ArrayList<User>();
//			List <Rating> ratings = new ArrayList<Rating>();
			
			for(int i = 0; i < seats.size(); i++) {
				if(seats.get(i).getTripId().equals(trip.getId())) {

					User user = PersistenceFactory.newUserDao().findById(seats.get(i).getUserId());
					users.add(user);
					seatsValidos.add(seats.get(i));
				}
			}
			
			request.setAttribute("seats", seatsValidos);
			request.setAttribute("users", users);
//			request.setAttribute("ratings", ratings);
			
		} catch (Exception e) {
			Log.error("Algo ha ocurrido al comentar");
			return "FRACASO";
		}
		
		return "EXITO";
	}

}
