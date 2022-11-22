package nebula.domain;

import nebula.domain.OrderPlaced;
import nebula.domain.OrderChanged;
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

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        // Get request from Inventory
        //nebula.external.Inventory inventory =
        //    Application.applicationContext.getBean(nebula.external.InventoryService.class)
        //    .getInventory(/** mapping value needed */);

    }
    @PostUpdate
    public void onPostUpdate(){


        OrderChanged orderChanged = new OrderChanged(this);
        orderChanged.publishAfterCommit();

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
