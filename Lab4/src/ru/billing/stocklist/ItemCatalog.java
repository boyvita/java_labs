package ru.billing.stocklist;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// id add() item get(id) item[] get(price, category) remove id[]
public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private HashMap<Pair<Float, Category>, HashMap<Integer, GenericItem>> catalogPairs = new HashMap<Pair<Float, Category>, HashMap<Integer, GenericItem>>();
    private Integer IDLast = 0;
    
    public void addItem(GenericItem item) {
        catalog.put(this.IDLast, item);
        HashMap<Integer, GenericItem> list = catalogPairs.get(new Pair(item.price, item.category));
        if (list != null) {
            list.put(this.IDLast, item);
        } else {
            list = new HashMap<Integer, GenericItem>();
            list.add(item);
            catalogPairs.put(new Pair(item.price, item.category), list);
        }
    }
    
    public GenericItem get(Integer id) {
        GenericItem item = catalog.get(id);
        if (item != null) {
            return item;
        } else {
            return null;
        }
    }
    
    public ArrayList<GenericItem> get(float price, Category category) {
        ArrayList<GenericItem> list = catalogPairs.get(new Pair<Float, Category>(price, category));
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }
    
    public void remove(int id)
            throws Exception {
        if (!catalog.containsKey(id)) {
            throw new Exception("There isn't that id");
        }
        else {
            catalog.remove(id);
        }
    }
    
}
