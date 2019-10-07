package microservices.orderhistory;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class OrderHistory {
    public OrderHistory() {
    }

    public OrderHistory(String fullname, Date created_at) {
        this.fullname = fullname;
        this.createdAt = createdAt;
    }

    private String fullname;
    private Date createdAt;

}
