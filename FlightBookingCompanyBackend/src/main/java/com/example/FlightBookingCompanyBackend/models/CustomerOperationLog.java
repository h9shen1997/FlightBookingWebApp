package com.example.FlightBookingCompanyBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "customer_operation_logs")
public class CustomerOperationLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "log_id")
  private Integer id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer")
  @JsonIgnore
  private Customer customer;
  @Column(name = "operation")
  private String operation;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "reservation")
  private Reservation reservation;
  @Column(name = "performed_at")
  private LocalDateTime performedAt;

  public CustomerOperationLog(Integer id, Customer customer, String operation,
      Reservation reservation, LocalDateTime performedAt) {
    this.id = id;
    this.customer = customer;
    this.operation = operation;
    this.reservation = reservation;
    this.performedAt = performedAt;
  }

  protected CustomerOperationLog() {
  }

  public Integer getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }

  public LocalDateTime getPerformedAt() {
    return performedAt;
  }

  public void setPerformedAt(LocalDateTime performedAt) {
    this.performedAt = performedAt;
  }
}
