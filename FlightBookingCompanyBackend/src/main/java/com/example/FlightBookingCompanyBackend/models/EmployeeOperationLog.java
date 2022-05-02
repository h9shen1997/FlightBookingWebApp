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
@Table(name = "employee_operation_logs")
public class EmployeeOperationLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "log_id")
  private Integer id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "employee")
  @JsonIgnore
  private Employee employee;
  @Column
  private String operation;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "flight")
  private Flight flight;
  @Column(name = "performed_at")
  private LocalDateTime performedAt;

  public EmployeeOperationLog(Integer id, Employee employee, String operation, Flight flight,
      LocalDateTime performedAt) {
    this.id = id;
    this.employee = employee;
    this.operation = operation;
    this.flight = flight;
    this.performedAt = performedAt;
  }

  protected EmployeeOperationLog() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    operation = operation;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public LocalDateTime getPerformedAt() {
    return performedAt;
  }

  public void setPerformedAt(LocalDateTime performedAt) {
    this.performedAt = performedAt;
  }
}
