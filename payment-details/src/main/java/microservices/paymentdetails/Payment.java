package microservices.paymentdetails;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name="\"payment\"")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private String cc_name;
    private String cc_validDate;
    private String cc_code;

    public Payment(int id, String cc_name, String cc_validDate, String cc_code) {
        this.id = id;
        this.cc_name = cc_name;
        this.cc_validDate = cc_validDate;
        this.cc_code = cc_code;
    }

    public Payment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
