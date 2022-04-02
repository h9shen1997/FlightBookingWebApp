package repositories;

import models.CustomerOperationLog;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOperationLogRepository extends
    CrudRepository<CustomerOperationLog, Integer> {

}
