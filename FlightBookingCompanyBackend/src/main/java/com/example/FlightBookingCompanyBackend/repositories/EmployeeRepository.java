package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.Employee;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

  @Query(value = "select * from users u, employees e where u.employee = true and u.id = e.id", nativeQuery = true)
  List<Employee> findAllEmployees();

  @Query(value = "select * from users u, employees e where u.user_name = :name", nativeQuery = true)
  Employee findEmployeeByUserName(@Param("name") String name);

  @Modifying
  @Transactional
  @Query(value = "delete from users u where u.user_name = :name", nativeQuery = true)
  void deleteEmployeeByUserName(@Param("name") String name);

}
