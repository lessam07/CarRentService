package microservies.orderdetails;

import org.springframework.data.repository.CrudRepository;

public interface InfoRepository extends CrudRepository<Order, Integer> {

}
