package microservices.orderhistory;
import microservices.orderhistory.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class OrderHistoryApi {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplate restTemplate2;
    @GetMapping("/{userId}")
    public List<OrderHistory> getAllBooks(
            @PathVariable int userId) {

        // get all order by userId
        Order orders = restTemplate.getForObject(
                "http://order-details/booking/" + userId,
                Order.class);
        System.out.println(orders.getCreatedAt());
        // get fullname & created date for each order in a list

        List<OrderHistory> userHistoryist = new ArrayList<>();

        User userInfo = restTemplate2.getForObject(
                    "http://user-details/user/" + userId,
                    User.class);
        System.out.println(userInfo.getFullname());

            userHistoryist.add(new OrderHistory(userInfo.getFullname(),
                    orders.getCreatedAt(),orders.getCarType()));


       return userHistoryist;
 }


}
