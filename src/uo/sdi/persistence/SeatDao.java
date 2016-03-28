package uo.sdi.persistence;

import uo.sdi.model.Seat;
import uo.sdi.persistence.util.GenericDao;

public interface SeatDao extends GenericDao<Seat, Long[]> {

	Seat findByUserAndTrip(Long userId, Long tripId);

	Seat findById(Long idSeat);

	void aceptarPlaza(Long idTrip, Long idUsuario);
	
	void rechazarPlaza(Long idTrip, Long idUsuario);
}
