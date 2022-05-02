package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.Trip;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TripRepository extends CrudRepository<Trip, Integer> {

  @Query(value = "select * from trips t where t.duration < :duration", nativeQuery = true)
  List<Trip> getTripsByDurationCutoff(@Param("duration") Integer duration);

  @Query(value = "select * from trips t where t.total_cost < :cost", nativeQuery = true)
  List<Trip> getTripByCostCutoff(@Param("cost") Double cost);

  @Query(value = "select * from trips t where t.total_mileage < :mileage", nativeQuery = true)
  List<Trip> getTripByMileageCutoff(@Param("mileage") Integer mileage);
}
