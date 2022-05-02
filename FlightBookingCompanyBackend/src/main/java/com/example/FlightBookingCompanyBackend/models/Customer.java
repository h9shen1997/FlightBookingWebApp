package com.example.FlightBookingCompanyBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "customers")
public class Customer extends User {

  @Column(name = "status")
  private String flyerStatus;
  @Column(name = "miles_accrued")
  private Integer milesAccrued;
  @Column(name = "travel_companion")
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
  private Set<Customer> companions = new HashSet<>();
  @JoinColumn(name = "travel_companion", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Customer customer;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
  @JsonIgnore
  private List<CustomerOperationLog> logs;

  protected Customer() {
  }

  public Customer(Integer id, String firstName, String lastName, String userName,
      String password, String email, Date dob, String flyerStatus, Integer milesAccrued,
      Set<Customer> companions, Boolean employee) {
    super(id, firstName, lastName, userName, password, email, dob, employee);
    this.flyerStatus = flyerStatus;
    this.milesAccrued = milesAccrued;
    this.companions = companions;
  }

  public String getFlyerStatus() {
    return flyerStatus;
  }

  public void setFlyerStatus(String flyerStatus) {
    this.flyerStatus = flyerStatus;
  }

  public Integer getMilesAccrued() {
    return milesAccrued;
  }

  public void setMilesAccrued(Integer milesAccrued) {
    this.milesAccrued = milesAccrued;
  }

  public Set<Customer> getCompanions() {
    return companions;
  }

  public void setCompanions(Set<Customer> companions) {
    this.companions = companions;
  }
}
