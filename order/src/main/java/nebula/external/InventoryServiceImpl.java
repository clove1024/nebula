package nebula.external;

import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {


    /**
     * Fallback
     */
    public Inventory getInventory(Long id) {
        Inventory inventory = new Inventory();
        inventory.setStock(1);
        return inventory;
    }
}

