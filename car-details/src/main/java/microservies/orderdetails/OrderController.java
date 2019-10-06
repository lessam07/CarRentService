package microservies.orderdetails;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController

@RequestMapping("/")
public class OrderController {
    private InfoRepository infoRepo;
    @Autowired
    public OrderController(InfoRepository infoRepo) {
        this.infoRepo = infoRepo;
    }

    @GetMapping("/bookings")
    public Iterable<Order> getAllBookings() {

        return infoRepo.findAll();
    }
    @GetMapping("/bookings/{id}")
    public Optional<Order> getOrderbyID(@PathVariable("id") int id) {

        return infoRepo.findById(id);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody @Valid Order order) {

        infoRepo.save(order);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping(value = {"/edit", "/edit/{id}"})
    public ResponseEntity<?> orderEditForm(@PathVariable (required = false, name = "id") int id) {
        Optional<Order> optionalOrder = infoRepo.findById(id);
        if ( optionalOrder.isPresent() ) {
            return new ResponseEntity<>(infoRepo.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        try {
            infoRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }


//    @PostMapping(path="/update/{id}", consumes="application/json")
//    public Order patchOrder(@PathVariable("id") int id,
//                                  @RequestBody Order patch) {
//        Order information = infoRepo.findById(id).get();
//        if (patch.getLocation() != null) {
//            information.setLocation(patch.getLocation());
//        }
//        if (patch.getPickup_date() != null) {
//            information.setPickup_date(patch.getPickup_date());
//        }
//        if (patch.getReturn_date() != null) {
//            information.setReturn_date(patch.getReturn_date());
//        }
//        if (patch.getCar_type() != null) {
//            information.setCar_type(patch.getCar_type());
//        }
//
//        return infoRepo.save(information);
//    }
}

