package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Trip;
import com.example.FlightBookingCompanyBackend.repositories.TripRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TripRestOrmDao {

  @Autowired
  TripRepository tripRepository;

  @GetMapping("/trips")
  public List<Trip> getAllTrips() {
    return (List<Trip>) tripRepository.findAll();
  }

  @GetMapping("/trips/duration/{duration}")
  public List<Trip> getTripsByDurationCutoff(@PathVariable("duration") Integer duration) {
    return tripRepository.getTripsByDurationCutoff(duration);
  }

  @GetMapping("/trips/mileage/{mileage}")
  public List<Trip> getTripsByMileageCutoff(@PathVariable("mileage") Integer mileage) {
    return tripRepository.getTripByMileageCutoff(mileage);
  }

  @GetMapping("/trips/cost/{cost}")
  public List<Trip> getTripsByCostCutoff(@PathVariable("cost") Double cost) {
    return tripRepository.getTripByCostCutoff(cost);
  }

  @PostMapping("/trips")
  public Trip createTrip(@RequestBody Trip trip) {
    return tripRepository.save(trip);
  }
}
