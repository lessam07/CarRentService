package microservices.orderhistory;
import microservies.orderdetails.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/history")
public class OrderHistoryApi {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public Order getAllBooks(
            @PathVariable int userId) {

        // get all order by userId
        Order orders = restTemplate.getForObject(
                "http://order-details/booking/" + userId,
                Order.class);



        // get fullname & created date for each order in a list

//        List<OrderHistory> bookCatalogList = new ArrayList<>();
//
//        for (Order order : orders) {
//            User userFull = restTemplate.getForObject(
//                    "http://user-details/user/" + order.getId(),
//                    User.class);
//
//            bookCatalogList.add(new OrderHistory(userFull.getFullname(),
//                    orders.getCreated_at()));
//        }

       return orders;
 }

}
