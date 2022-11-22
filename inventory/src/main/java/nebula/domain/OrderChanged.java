package nebula.domain;

import nebula.domain.*;
import nebula.infra.AbstractEvent;
import lombok.*;
import java.util.*;
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
}


