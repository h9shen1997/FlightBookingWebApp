package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.Reservation;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

  @Query(value = "select * from reservations r where r.reservation_code = :code", nativeQuery = true)
  Reservation findReservationByCode(@Param("code") String code);

  @Modifying
  @Transactional
  @Query(value = "delete from reservations r where r.reservation_code = :code", nativeQuery = true)
  void deleteReservationByCode(@Param("code") String code);
}
