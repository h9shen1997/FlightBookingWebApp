package com.example.FlightBookingCompanyBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trip_id")
  private Integer id;
  @Column(name = "duration")
  private Integer duration; // in minutes
  @Column(name = "total_mileage")
  private Integer totalMiles;
  @Column(name = "total_cost")
  private Double totalCost;
  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation")
  private Reservation reservation;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
  private List<Flight> flights;

  protected Trip() {
  }

  public Trip(Integer id, List<Flight> flights) {
    this.id = id;
    Integer duration = 0;
    Integer totalMiles = 0;
    Double totalCost = 0d;
    for (Flight flight : flights) {
      duration += flight.getDuration();
      totalMiles += flight.getMileage();
      totalCost += flight.getCost();
    }
    this.duration = duration;
    this.totalMiles = totalMiles;
    this.totalCost = totalCost;
    this.reservation = null;
    this.flights = flights;
  }

  public List<Flight> getFlights() {
    return flights;
  }

  public void setFlights(List<Flight> flights) {
    this.flights = flights;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Integer getTotalMiles() {
    return totalMiles;
  }

  public void setTotalMiles(Integer totalMiles) {
    this.totalMiles = totalMiles;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }
}
