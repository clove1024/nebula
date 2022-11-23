package nebula.external;

import org.springframework.stereotype.Service;

@Service
public class FallbackServiceImpl implements InventoryService {


    /**
     * Fallback
     */
    public Inventory getInventory(Long id) {
        Inventory fallbackValue = new Inventory();
        fallbackValue.setStock(1);
        return fallbackValue;
    }

    /*

    public class InventoryServiceFallback implements InventoryService{
    public Inventory getInventory(Long id){
        Inventory fallbackValue = new Inventory();
        fallbackValue.setStock(1L);

        return fallbackValue; 
     */
}

