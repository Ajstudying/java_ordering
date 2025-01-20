package ordering_program.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepo;
    @PostMapping
    public ResponseEntity createOrderList(@RequestBody OrderRequest reque){
        System.out.println(reque);

        if(reque.getCompany() == null || reque.getCompany().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reque.getTitle() == null || reque.getTitle().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reque.getCreateTime() == null || reque.getCreateTime().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reque.getUnit() == null || reque.getUnit().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reque.getQuantity() == 0 || reque.getQuantity() < 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(reque.getPrice() == 0|| reque.getPrice() < 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Order newOrder = new Order();
        newOrder.setTitle(reque.getTitle());
        newOrder.setCompany(reque.getCompany());
        newOrder.setUnit(reque.getUnit());
        newOrder.setCreatedTime(LocalDate.parse(reque.getCreateTime()));
        newOrder.setQuantity(reque.getQuantity());
        newOrder.setPrice(reque.getPrice());
        Order savedOrder = orderRepo.save(newOrder);
        if(savedOrder != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.ok().build();
    }

}
