package models;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends User {

  @Column(name = "status")
  private String flyerStatus;
  @Column(name = "miles_accrued")
  private Integer milesAccrued;
  @OneToMany(fetch = FetchType.LAZY)
  @Column(name = "travel_companion")
  private Set<Customer> companions;

  public Customer() {
  }

  public Customer(Integer id, String firstName, String lastName, String userName,
      String password, String email, Date dob, String flyerStatus, Integer milesAccrued,
      Set<Customer> companions) {
    super(id, firstName, lastName, userName, password, email, dob);
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
