package com.example.FlightBookingCompanyBackend.daos;

import com.example.FlightBookingCompanyBackend.models.CustomerOperationLog;
import com.example.FlightBookingCompanyBackend.repositories.CustomerOperationLogRepository;
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
public class CustomerOperationLogRestOrmDao {

  @Autowired
  CustomerOperationLogRepository customerOperationLogRepository;

  @GetMapping("/customers/{username}/log")
  public List<CustomerOperationLog> findOperationLogByCustomerId(
      @PathVariable("username") String username) {
    return customerOperationLogRepository.findLogsByCustomerUserName(
        username);
  }

  @PostMapping("/customers/log")
  public CustomerOperationLog createCustomerOperationLog(@RequestBody CustomerOperationLog log) {
    return customerOperationLogRepository.save(log);
  }
}
