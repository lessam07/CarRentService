package car.car1.repository_;
import org.springframework.data.repository.CrudRepository;
import car.car1.User;
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
