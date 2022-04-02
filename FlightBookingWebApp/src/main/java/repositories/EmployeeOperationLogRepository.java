package repositories;

import models.EmployeeOperationLog;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeOperationLogRepository extends
    CrudRepository<EmployeeOperationLog, Integer> {

}
