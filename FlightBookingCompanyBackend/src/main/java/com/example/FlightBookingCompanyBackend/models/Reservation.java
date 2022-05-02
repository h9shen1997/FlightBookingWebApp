package com.example.FlightBookingCompanyBackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

  private static final double[] CLASS_MULTIPLIER = new double[]{0d, 1.2, 2.5, 4d};
  private static final char[] CODE_ARR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
      '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
      'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id")
  private Integer id;
  @Column(name = "reservation_code")
  private String reservationCode;
  @Column(name = "flight_class")
  private String flightClass;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "trip")
  private Trip trip;
  @Column(name = "reservation_cost")
  private Double reservationCost;

  public Reservation(Integer id, String reservationCode, String flightClass, Trip trip,
      Double reservationCost) {
    this.id = id;
    this.reservationCode = reservationCode;
    this.flightClass = flightClass;
    this.trip = trip;
    this.reservationCost = reservationCost;
  }

  protected Reservation() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getReservationCode() {
    return reservationCode;
  }

  public void setReservationCode(String reservationCode) {
    this.reservationCode = reservationCode;
  }

  public String getFlightClass() {
    return flightClass;
  }

  public void setFlightClass(String flightClass) {
    this.flightClass = flightClass;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public Double getReservationCost() {
    return reservationCost;
  }

  public void setReservationCost(Double reservationCost) {
    this.reservationCost = reservationCost;
  }
}
