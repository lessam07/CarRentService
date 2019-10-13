package car.car1.repository_;
import car.car1.Order;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Order, Integer> {
}

