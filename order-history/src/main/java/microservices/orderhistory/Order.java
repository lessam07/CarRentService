package microservices.orderhistory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name="\"booking\"")
@Getter
@Setter
public class Order {
    public Order() {
    }

    public Order(Date created_at, @NotBlank(message = "Location is required") String location, @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY") String pickup_date, @Pattern(regexp = "^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message = "Must be formatted MM/YY") String return_date, @NotBlank(message = "Car Type is required") String car_type, int user_id) {
        this.created_at = created_at;
        this.location = location;
        this.pickup_date = pickup_date;
        this.return_date = return_date;
        this.car_type = car_type;
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private Date created_at;
    @NotBlank(message="Location is required")
    private String location;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String pickup_date;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String return_date;
    @NotBlank(message="Car Type is required")
    protected String car_type;
    private int user_id;
    @PrePersist
    void createdAt() {
        this.created_at = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
