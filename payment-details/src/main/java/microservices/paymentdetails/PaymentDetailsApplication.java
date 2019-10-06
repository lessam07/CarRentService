package microservices.paymentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentDetailsApplication.class, args);
	}

}
