package microservices.orderhistory;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplate restTemplate2;
    @HystrixCommand(
            fallbackMethod = "getFallbackOrderHistory",
            threadPoolKey = "OrderHistoryPool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }

    )
    public List<OrderHistory> getAllBooks(
            @PathVariable int userId) {

//        String apiCredentials = "rest-client:p@ssword";
//        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + base64Credentials);
//        HttpEntity<String> entity = new HttpEntity<>(headers);

        // get all order by userId
        Order orders = restTemplate.getForObject(
                "http://order-details/booking/" + userId,
                Order.class);
        System.out.println(orders.getCreatedAt());
        // get fullname & created date for each order in a list

        List<OrderHistory> userHistoryList = new ArrayList<>();

        User userInfo = restTemplate2.getForObject(
                "http://user-details/users/" + userId,
                User.class);
        System.out.println(userInfo.getFullname());

        userHistoryList.add(new OrderHistory(userInfo.getFullname(),
                orders.getCreatedAt(),orders.getCarType()));


        return userHistoryList;
    }

    public List<OrderHistory> getFallbackOrderHistory(@PathVariable int userId) {
        return Arrays.asList(new OrderHistory("No user",null,"no car type"));
    }
}
