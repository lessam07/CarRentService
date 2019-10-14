package microservices.paymentdetails;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name="\"payment\"")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private String ccName;
    private String ccValidDate;
    private String ccCode;

    public Payment(String ccName, String ccValidDate, String ccCode) {
        this.ccName = ccName;
        this.ccValidDate = ccValidDate;
        this.ccCode = ccCode;
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

