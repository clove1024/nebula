package nebula.domain;

import nebula.domain.*;
import nebula.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderChanged extends AbstractEvent {

    private Long id;
    private Long productId;
    private Long customerId;
    private Integer qty;
    private String customerName;
    private String customerAddress;
    private String status;

    public OrderChanged(Order aggregate){
        super(aggregate);
    }
    public OrderChanged(){
        super();
    }
}
