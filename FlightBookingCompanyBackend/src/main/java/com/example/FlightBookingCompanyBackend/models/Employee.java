package com.example.FlightBookingCompanyBackend.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employees")
public class Employee extends User {

  @Column
  private String passcode;

  public Employee(Integer id, String firstName, String lastName, String userName,
      String password, String email, Date dob, String passcode, Boolean employee) {
    super(id, firstName, lastName, userName, password, email, dob, employee);
    this.passcode = passcode;
  }

  protected Employee() {
  }

  public String getPasscode() {
    return passcode;
  }

  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }
}
