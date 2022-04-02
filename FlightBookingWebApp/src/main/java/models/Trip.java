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
@Table(name = "trips")
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trip_id")
  private Integer id;
  @Column
  private Integer duration; // in minutes
  @Column(name = "total_mileage")
  private Integer totalMiles;
  @Column(name = "total_cost")
  private Double totalCost;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation")
  private Reservation reservation;

  public Trip() {
  }

  public Trip(Integer id, Integer duration, Integer totalMiles, Double totalCost,
      Reservation reservation) {
    this.id = id;
    this.duration = duration;
    this.totalMiles = totalMiles;
    this.totalCost = totalCost;
    this.reservation = reservation;
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
