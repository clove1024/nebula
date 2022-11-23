package nebula.domain;

import nebula.domain.OrderPlaced;
import nebula.domain.OrderCancelled;
import nebula.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;

    private Long productId;

    private Long customerId;

    private Integer qty;

    private String customerName;

    private String customerAddress;

    private String status;

    @PrePersist
    public void onPrePersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        // Get request from Inventory
        nebula.external.Inventory inventory =
           OrderApplication.applicationContext.getBean(nebula.external.InventoryService.class)
           .getInventory(getProductId());

           System.out.println(inventory);

        if (getQty() > inventory.getStock()) throw new RuntimeException("Out of Stock");

        System.out.println();

        orderPlaced.publishAfterCommit();

    }

    @PreRemove
    public void onPreRemove(){


        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
