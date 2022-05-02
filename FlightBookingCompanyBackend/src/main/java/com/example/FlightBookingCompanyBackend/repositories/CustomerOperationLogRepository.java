package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.CustomerOperationLog;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerOperationLogRepository extends
    CrudRepository<CustomerOperationLog, Integer> {

  @Query(value = "select * from customer_operation_logs logs, users u, customers c where logs.customer = c.id and u.id = c.id and u.user_name = :name", nativeQuery = true)
  List<CustomerOperationLog> findLogsByCustomerUserName(@Param("name") String name);
}
