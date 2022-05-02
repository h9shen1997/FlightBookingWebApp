package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Flight;
import com.example.FlightBookingCompanyBackend.repositories.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FlightRestOrmDao {

  @Autowired
  FlightRepository flightRepository;

  @PostMapping("/flights")
  public Flight createFlights(@RequestBody Flight flight) {
    return flightRepository.save(flight);
  }

  @GetMapping("/flights/departure/{departure}")
  public List<Flight> findFlightsByDepartureAirport(@PathVariable("departure") String departure) {
    return flightRepository.findFlightsByDeparture(departure);
  }

  @GetMapping("/flights/arrival/{arrival}")
  public List<Flight> findFlightsByArrivalAirport(@PathVariable("arrival") String arrival) {
    return flightRepository.findFlightsByArrival(arrival);
  }

  @GetMapping("/flights/airline/{airline}")
  public List<Flight> findFlightsByAirline(@PathVariable("airline") String airline) {
    return flightRepository.findFlightsByAirlineName(airline);
  }

  @DeleteMapping("/flights/{airline}/{number}")
  public void deleteFlightsByAirlineNumber(@PathVariable("airline") String airline,
      @PathVariable("number") String number) {
    flightRepository.deleteFlightsByAirlineNumber(airline, number);
  }
}
