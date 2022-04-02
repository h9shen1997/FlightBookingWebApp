package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {

  @Column
  private String passcode;

  public Employee(Integer id, String firstName, String lastName, String userName,
      String password, String email, Date dob, String passcode) {
    super(id, firstName, lastName, userName, password, email, dob);
    this.passcode = passcode;
  }

  public Employee() {
  }

  public String getPasscode() {
    return passcode;
  }

  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }
}
