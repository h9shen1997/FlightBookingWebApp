package com.example.FlightBookingCompanyBackend.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  protected Integer id;
  @Column(name = "first_name")
  protected String firstName;
  @Column(name = "last_name")
  protected String lastName;
  @Column(name = "user_name")
  protected String userName;
  @Column
  protected String password;
  @Column
  protected String email;
  @Column
  protected Date dob;
  @Column
  protected Boolean employee;

  protected User() {
  }

  public User(Integer id, String firstName, String lastName, String userName, String password,
      String email, Date dob, Boolean employee) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.dob = dob;
    this.employee = employee;
  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Boolean isEmployee() {
    return employee;
  }

  public void setEmployee(Boolean employee) {
    this.employee = employee;
  }
}
