package ru.billing.client;

import java.util.Date;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;

public class CatalogStubLoader implements CatalogLoader {
    
    @Override
    public void load(ItemCatalog cat)
            throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        try {
            cat.addItem(item1);
            cat.addItem(item2);
            cat.addItem(item2);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }
}
