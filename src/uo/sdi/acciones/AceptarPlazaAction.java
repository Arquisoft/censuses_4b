package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.*;

import alb.util.log.Log;
import uo.sdi.model.*;
import uo.sdi.persistence.PersistenceFactory;

public class AceptarPlazaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			Long idSolicitante = Long.parseLong(request.getParameter("solicitante"));
			User solicitante = PersistenceFactory.newUserDao().findById(idSolicitante);

			Long idTrip = Long.parseLong(request.getParameter("seat"));
			Trip trip = PersistenceFactory.newTripDao().findById(idTrip);

			Seat seat = PersistenceFactory.newSeatDao().findByUserAndTrip(solicitante.getId(), trip.getId());
			
			if(seat.getStatus().equals(SeatStatus.PENDIENTE)) {
			
				int plazas = trip.getAvailablePax() - 1;
				trip.setAvailablePax(plazas);
				PersistenceFactory.newTripDao().update(trip);
	
				PersistenceFactory.newSeatDao().aceptarPlaza(trip.getId(),
						solicitante.getId());
	
				if (plazas == 0) { // Dejar fuera al resto
					List<Seat> seats = PersistenceFactory.newSeatDao().findAll();
	
					for (int i = 0; i < seats.size(); i++) {
						if (seats.get(i).getUserId().equals(solicitante.getId())
								&& seats.get(i).getStatus()
										.equals(SeatStatus.PENDIENTE)) {
							seats.get(i).setStatus(SeatStatus.SIN_PLAZA);
						}
					}
				}
			} else {
				Log.info("Ya está aceptada");
				return "FRACASO";
			}

		} catch (Exception e) {
			Log.error("Ha habido un problema aceptando plazas");
			return "FRACASO";
		}

		return "EXITO";
	}

}
