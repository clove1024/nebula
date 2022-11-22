package nebula.domain;

import nebula.domain.*;
import nebula.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long productId;
    private Long customerId;
    private Integer qty;
    private String customerName;
    private String customerAddress;
    private String status;

    public OrderCancelled(Order aggregate){
        super(aggregate);
    }
    public OrderCancelled(){
        super();
    }
}
