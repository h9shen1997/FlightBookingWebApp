package models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "flight_id")
  private Integer id;
  @Column
  private String airline;
  @Column(name = "departure_airport")
  private String departureAirport;
  @Column(name = "arrival_airport")
  private String arrivalAirport;
  @Column(name = "flight_number")
  private String flightNumber;
  @Column(name = "cost")
  private Double cost;
  @Column
  private Integer mileage;
  @Column
  private Integer duration; // in minutes
  @Column(name = "departure_time")
  private LocalDateTime departureTime;
  @Column(name = "arrival_time")
  private LocalDateTime arrivalTime;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trip")
  private Trip trip;

  public Flight(Integer id, String airline, String departureAirport, String arrivalAirport,
      String flightNumber, Double cost, Integer mileage, Integer duration,
      LocalDateTime departureTime, LocalDateTime arrivalTime, Trip trip) {
    this.id = id;
    this.airline = airline;
    this.departureAirport = departureAirport;
    this.arrivalAirport = arrivalAirport;
    this.flightNumber = flightNumber;
    this.cost = cost;
    this.mileage = mileage;
    this.duration = duration;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.trip = trip;
  }

  public Flight() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public void setArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Integer getMileage() {
    return mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(LocalDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public LocalDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }
}
