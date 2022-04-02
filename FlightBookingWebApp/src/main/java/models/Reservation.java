package models;

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

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id")
  private Integer id;
  @Column(name = "reservation_code")
  private String reservationCode;
  @Column(name = "flight_class")
  private String flightClass;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trip")
  private Trip trip;

  public Reservation(Integer id, String reservationCode, String flightClass, Trip trip) {
    this.id = id;
    this.reservationCode = reservationCode;
    this.flightClass = flightClass;
    this.trip = trip;
  }

  public Reservation() {

  }
}
