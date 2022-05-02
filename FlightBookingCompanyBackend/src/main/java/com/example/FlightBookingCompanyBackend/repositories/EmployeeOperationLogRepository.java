package com.example.FlightBookingCompanyBackend.repositories;

import com.example.FlightBookingCompanyBackend.models.EmployeeOperationLog;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeOperationLogRepository extends
    CrudRepository<EmployeeOperationLog, Integer> {

  @Query(value = "select * from employee_operation_logs logs, users u, employees e where logs.employee = e.id and e.id = u.id and u.user_name = :name", nativeQuery = true)
  List<EmployeeOperationLog> findLogsByEmployeeUserName(@Param("name") String name);
}
