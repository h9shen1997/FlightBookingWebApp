package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.Flight;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

  @Query(value = "select * from flights f where f.departure_airport = :airport", nativeQuery = true)
  List<Flight> findFlightsByDeparture(@Param("airport") String airport);

  @Query(value = "select * from flights f where f.arrival_airport = :airport", nativeQuery = true)
  List<Flight> findFlightsByArrival(@Param("airport") String airport);

  @Query(value = "select * from flights f where f.airline = :airline", nativeQuery = true)
  List<Flight> findFlightsByAirlineName(@Param("airline") String airline);

  @Query(value = "select * from airports", nativeQuery = true)
  List<String> findAllAirport();

  @Modifying
  @Transactional
  @Query(value = "delete from flights f where f.airline = :airline and f.flight_number = :number", nativeQuery = true)
  void deleteFlightsByAirlineNumber(@Param("airline") String airline,
      @Param("number") String number);
}
