package microservices.paymentdetails;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController

@RequestMapping("/")
public class PaymentController {
    private PaymentRepository infoRepo;
    @Autowired
    public PaymentController(PaymentRepository infoRepo) {
        this.infoRepo = infoRepo;
    }
    @GetMapping("/allPayments")
    public Iterable<Payment> getAllPayments() {

        return infoRepo.findAll();
    }
    @GetMapping("/payments/{id}")
    public Optional<Payment> getPaymentByID(@PathVariable("id") int id) {

        return infoRepo.findById(id);
    }

    @PostMapping("/addPayment")
    public ResponseEntity<?> addPayment(@RequestBody @Valid Payment payment) {

        infoRepo.save(payment);

        return new ResponseEntity<>(OK);

    }




}
