package daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import repositories.CustomerRepository;

@RestController
@CrossOrigin(origins = "*")
public class CustomerRestOrmDao {

  @Autowired
  CustomerRepository customerRepository;

}
