package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.EmployeeOperationLog;
import com.example.FlightBookingCompanyBackend.repositories.EmployeeOperationLogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeOperationLogRestOrmDao {

  @Autowired
  EmployeeOperationLogRepository employeeOperationLogRepository;

  @GetMapping("/employees/{username}/log")
  public List<EmployeeOperationLog> findOperationLogByEmployeeId(
      @PathVariable("username") String username) {
    return employeeOperationLogRepository.findLogsByEmployeeUserName(
        username);
  }

  @PostMapping("/employees/log")
  public EmployeeOperationLog createEmployeeOperationLog(@RequestBody EmployeeOperationLog log) {
    return employeeOperationLogRepository.save(log);
  }
}
