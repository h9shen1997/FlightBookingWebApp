package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.Employee;
import com.example.FlightBookingCompanyBackend.repositories.EmployeeRepository;
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
public class EmployeeRestOrmDao {

  @Autowired
  EmployeeRepository employeeRepository;

  /**
   * Get all the employees.
   *
   * @return a list of employees.
   */
  @GetMapping("/employees")
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAllEmployees();
  }

  /**
   * Get employee by username.
   *
   * @param username employee username.
   * @return the specified employee.
   */
  @GetMapping("/employees/{username}")
  public Employee findEmployeeByUsername(@PathVariable("username") String username) {
    return employeeRepository.findEmployeeByUserName(username);
  }

  /**
   * Create an employee with employee as a json request body.
   *
   * @param employee new employee.
   * @return new employee.
   */
  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  /**
   * Update employee passcode.
   *
   * @param passcode new passcode.
   * @param username employee username.
   * @return employee after update
   */
  @PutMapping("/employees/{username}")
  public Employee updateEmployee(@RequestBody String passcode,
      @PathVariable("username") String username) {
    Employee employee = this.findEmployeeByUsername(username);
    if (employee == null) {
      return null;
    }
    employee.setPasscode(passcode);
    return employeeRepository.save(employee);
  }

  /**
   * Delete employee by username.
   *
   * @param username employee username.
   */
  @DeleteMapping("/employees/{username}")
  public void deleteEmployee(@PathVariable("username") String username) {
    employeeRepository.deleteEmployeeByUserName(username);
  }
}
