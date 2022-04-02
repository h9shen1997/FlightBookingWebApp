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
@Table(name = "recommendations")
public class Recommendation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recommendation_id")
  private Integer id;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trip")
  private Trip trip;
  @Column(name = "departure_airport")
  private String departureAirport;
  @Column
  private Integer likes;

  public Recommendation(Integer id, Trip trip, String departureAirport, Integer likes) {
    this.id = id;
    this.trip = trip;
    this.departureAirport = departureAirport;
    this.likes = likes;
  }

  public Recommendation() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }
}
