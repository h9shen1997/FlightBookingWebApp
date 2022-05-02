package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Customer;
import com.example.FlightBookingCompanyBackend.repositories.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CustomerRestOrmDao {

  private static final int BRONZE_CUTOFF = 10000;
  private static final int SILVER_CUTOFF = 25000;
  private static final int GOLD_CUTOFF = 40000;
  private static final int PLATINUM_CUTOFF = 55000;

  @Autowired
  CustomerRepository customerRepository;

  /**
   * Get all the customers.
   *
   * @return a list of customers
   */
  @GetMapping("/customers")
  public List<Customer> findAllCustomers() {
    return customerRepository.findAllCustomers();
  }

  /**
   * Get customer by username.
   *
   * @param username customer username.
   * @return the specified customer.
   */
  @GetMapping("/customers/{username}")
  public Customer findCustomerByUsername(@PathVariable("username") String username) {
    return customerRepository.findCustomerByUserName(username);
  }

  /**
   * Create a customer with customer as a json request body.
   *
   * @param customer new customer.
   * @return new customer.
   */
  @PostMapping("/customers")
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

  /**
   * Update the customer's miles accrued.
   *
   * @param password added miles.
   * @param username customer username.
   * @return customer after update.
   */
  @PutMapping("/customers/{username}/{password}")
  public Customer updateCustomer(@PathVariable("password") String password,
      @PathVariable("username") String username) {
    Customer customer = this.findCustomerByUsername(username);
    if (customer == null) {
      return null;
    }
    customer.setPassword(password);
    return customerRepository.save(customer);
  }

  /**
   * Add a companion for customer.
   *
   * @param companion companion.
   * @param username  customer username.
   * @return customer after update.
   */
  @PutMapping("/customers/{username}")
  public Customer updateCustomer(@RequestBody Customer companion,
      @PathVariable("username") String username) {
    Customer customer = this.findCustomerByUsername(username);
    if (customer == null) {
      return null;
    }
    customer.getCompanions().add(companion);
    return customerRepository.save(customer);
  }

  /**
   * Delete customer by id.
   *
   * @param username customer username.
   */
  @DeleteMapping("/customers/{username}")
  public void deleteCustomer(@PathVariable("username") String username) {
    customerRepository.deleteCustomerByUserName(username);
  }

  /**
   * Helped function to update status based on cutoff values after the miles were added.
   *
   * @param customer the customer to be updated.
   */
  private void updateStatusBasedOnMilesAccrued(Customer customer) {
    int milesAccrued = customer.getMilesAccrued();
    if (milesAccrued >= PLATINUM_CUTOFF) {
      customer.setFlyerStatus("PLATINUM");
    } else if (milesAccrued >= GOLD_CUTOFF) {
      customer.setFlyerStatus("GOLD");
    } else if (milesAccrued >= SILVER_CUTOFF) {
      customer.setFlyerStatus("SILVER");
    } else if (milesAccrued >= BRONZE_CUTOFF) {
      customer.setFlyerStatus("BRONZE");
    } else {
      customer.setFlyerStatus("GENERAL");
    }
  }
}
