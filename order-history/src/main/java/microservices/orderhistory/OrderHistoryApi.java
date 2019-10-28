package microservices.orderhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class OrderHistoryApi {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplate restTemplate2;
    @Autowired
    OrderService orderService;

    @GetMapping("/{userId}")
    public List<OrderHistory> getAllHistory(
            @PathVariable int userId) {
        return orderService.getAllBooks(userId);
    }
}
