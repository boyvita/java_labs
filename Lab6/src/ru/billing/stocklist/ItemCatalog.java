package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;
import ru.billing.exceptions.ItemAlreadyExistsException;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();
    
    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (this.findItemByID(item.getID()) != null) {
            throw new ItemAlreadyExistsException();
        }
        catalog.put(item.ID, item);
        ALCatalog.add(item);
    }
    
    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i.toString());
        }
    }
    
    public GenericItem findItemByID(int id) {
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }
    
    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.ID == id) {
                return i;
            }
        }
        return null;
    }
    
    
}
