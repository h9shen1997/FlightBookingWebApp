package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  @Query(value = "select * from users u, customers c where u.employee = false and u.id = c.id", nativeQuery = true)
  List<Customer> findAllCustomers();

  @Query(value = "select * from users u, customers c where u.user_name = :name and u.employee = 0", nativeQuery = true)
  Customer findCustomerByUserName(@Param("name") String name);

  @Modifying
  @Transactional
  @Query(value = "delete from users u where u.user_name = :name", nativeQuery = true)
  void deleteCustomerByUserName(@Param("name") String name);
}
