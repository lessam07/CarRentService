package microservices.orderhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalog")
public class OrderHistoryApi {
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/{userId}")
    public List<OrderHistory> getAllBooks(
            @PathVariable int userId) {



        // get all order by userId
        UserBook  userBook = restTemplate.getForObject(
                "http://localhost:8081/bookings/" + userId,
                UserBook.class);

        // get fullname & created date for each order in a list

        List<OrderHistory> bookCatalogList = new ArrayList<>();

        for (Order book : userBook.getUserBooks()) {
            User bookRating = restTemplate.getForObject(
                    "http://localhost:8084/user/" + book.getId(),
                    User.class);

            bookCatalogList.add(new OrderHistory(book.getFullname(),
                    book.getCreated_at()));
        }

        return bookCatalogList;
    }

}
