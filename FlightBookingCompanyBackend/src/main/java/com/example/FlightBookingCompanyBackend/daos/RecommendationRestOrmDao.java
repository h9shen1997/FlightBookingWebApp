package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Flight;
import com.example.FlightBookingCompanyBackend.models.Trip;
import com.example.FlightBookingCompanyBackend.repositories.FlightRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RecommendationRestOrmDao {

  @Autowired
  FlightRepository flightRepository;

  @GetMapping("/recommendation/{departure}/{arrival}")
  public List<Trip> generateFlightsRecommendation(
      @PathVariable("departure") String departureAirport,
      @PathVariable("arrival") String arrivalAirport) {
    List<Flight> allFlights = (List<Flight>) flightRepository.findAll();
    List<Trip> trips = new ArrayList<>();
    List<String> allAirport = flightRepository.findAllAirport();

    Map<String, List<Flight>> graph = new HashMap<>();

    for (Flight flight : allFlights) {
      String departure = flight.getDepartureAirport();
      String arrival = flight.getArrivalAirport();
      if (!graph.containsKey(departure)) {
        graph.put(departure, new ArrayList<>());
      }
      if (!graph.containsKey(arrival)) {
        graph.put(arrival, new ArrayList<>());
      }
      graph.get(departure).add(flight);
    }
    Map<String, String> parent = new HashMap<>();
    // union find parent
    for (String s : allAirport) {
      parent.put(s, s);
    }
    dfs(graph, new ArrayList<>(), trips, departureAirport, arrivalAirport, parent);
    trips.sort(Comparator.comparingInt(a -> a.getFlights().size()));
    return trips;
  }

  private void dfs(Map<String, List<Flight>> graph, List<Flight> flights, List<Trip> trips,
      String departureAirport, String arrivalAirport, Map<String, String> parent) {
    if (departureAirport.equals(arrivalAirport)) {
      trips.add(new Trip(null, new ArrayList<>(flights)));
    }
    List<Flight> next = graph.get(departureAirport);
    for (Flight f : next) {
      String arrival = f.getArrivalAirport();
      if (!find(parent, arrival).equals(find(parent, departureAirport))) {
        // dfs with backtracking
        String prevParentForDeparture = find(parent, departureAirport);
        union(parent, departureAirport, arrival);
        flights.add(f);
        dfs(graph, flights, trips, arrival, arrivalAirport, parent);
        flights.remove(flights.size() - 1);
        parent.put(departureAirport, prevParentForDeparture);
      }
    }
  }

  private void union(Map<String, String> parent, String airportA, String airportB) {
    parent.put(airportA, parent.get(airportB));
  }

  private String find(Map<String, String> parent, String airport) {
    while (!parent.get(airport).equals(airport)) {
      parent.put(parent.get(airport), find(parent, parent.get(airport)));
    }
    return parent.get(airport);
  }
//
//  @GetMapping("/recommendation/{departure}/{arrival}/{maxConnection}")
//  public List<Flight> generateFlightRecommendation(
//      @PathVariable("departure") String departureAirport,
//      @PathVariable("arrival") String arrivalAirport,
//      @PathVariable("maxConnection") int maxConnection) {
//    List<Flight> allFlights = (List<Flight>) flightRepository.findAll();
//    HashMap<Integer, List<Flight>> allPossibleResults = new HashMap<>();
//
//    List<Flight> dfsPath = new LinkedList<>();
//    for (int i = 0; i < allFlights.size(); i++) {
//      dfsPath.clear();
//      dfs(dfsPath, allFlights, allPossibleResults, i, departureAirport, arrivalAirport,
//          maxConnection);
//    }
//
//    if (allPossibleResults.isEmpty()) {
//      return new ArrayList<>();
//    } else {
//      return allPossibleResults.get(Collections.min(allPossibleResults.keySet()));
//    }
//  }
//
//  private void dfs(List<Flight> path, List<Flight> allFlights,
//      HashMap<Integer, List<Flight>> allResults, int index, String departure, String arrival,
//      int maxConnection) {
//    Flight currFlight = allFlights.get(index);
//
//    if (path.contains(currFlight)) {
//      return;
//    }
//    if (!path.isEmpty() && !path.get(path.size() - 1).getArrivalAirport()
//        .equals(currFlight.getDepartureAirport())) {
//      return;
//    }
//    if (path.size() == 0 && !currFlight.getDepartureAirport().equals(departure)) {
//      return;
//    }
//
//    path.add(currFlight);
//    if (path.size() > maxConnection) {
//      path.remove(path.size() - 1);
//      return;
//    }
//
//    if (path.get(0).getDepartureAirport().equals(departure) && path.get(path.size() - 1)
//        .getArrivalAirport().equals(arrival)) {
//      List<Flight> temp = new LinkedList<>();
//      for (Flight flight : path) {
//        temp.add(flight);
//      }
//      allResults.put(temp.size(), temp);
//    }
//
//    for (int i = 0; i < allFlights.size(); i++) {
//      dfs(path, allFlights, allResults, i, departure, arrival, maxConnection);
//    }
//
//    path.remove(path.size() - 1);
//  }
}
