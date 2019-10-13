package car.car1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name="\"payment\"")
@Getter
@Setter
public class Order {
    public Order() {
    }

    public Order(@NotBlank(message = "Name is required") String ccName, String ccValidDate, @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY") String ccCode, String orderId) {
        this.ccName = ccName;
        this.ccValidDate = ccValidDate;
        this.ccCode = ccCode;
        this.orderId = orderId;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    @NotBlank(message="Name is required")
    private String ccName;
//    @NotBlank(message="City is required")
//    private String city;
    private String ccValidDate;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
//    private String ccExpiration;
//    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCode;
    private String orderId;
}
