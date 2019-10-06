package microservices.orderhistory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBook {

    private List<Order> userBooks;

    public UserBook() {
    }

    public UserBook(List<Order> userBooks) {
        this.userBooks = userBooks;
    }


    public Order[] getUserBooks() {
        return getUserBooks();
    }
}