package ru.billing.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.billing.stocklist.*;

public class Main {
    public static void main(String[] args)
            throws Exception {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String[] item_fld = "Конфеты ’Маска’;45;120".split(";");
        
        
        GenericItem[] items = {
                new GenericItem("g1", 250, Category.FOOD),
                new GenericItem("g2", 700, Category.DRESS),
                new GenericItem("g3", 250, Category.FOOD),
                new GenericItem("g4", 10, Category.PRINT),
                new GenericItem("g5", 5000, Category.PRINT),
                new FoodItem("f1", 90, null, dateformat.parse("01/5/2019"), (short) 7),
                new FoodItem("f2", 920, null, dateformat.parse("04/5/2019"), (short) 4),
                new FoodItem("f3", 910, null, dateformat.parse("03/5/2019"), (short) 7),
                new FoodItem("f4", 730, null, dateformat.parse("08/5/2019"), (short) 4),
                new FoodItem("f5", 230, null, dateformat.parse("08/5/2019"), (short) 3),
        };
        
        ItemCatalog catalog = new ItemCatalog();
        for (GenericItem item : items) {
            catalog.addItem(item);
        }
        
        GenericItem item1 = catalog.get(5);
        if (item1 != null) {
            item1.printAll();
        }
        for (GenericItem item : catalog.get(250, Category.FOOD)) {
            item.printAll();
        }
        catalog.remove(4);
        
//        long begin = new Date().getTime();
//        for (int i = 0; i < 1000000; i++) {
//            catalog.findItemByID(10);
//        }
//        long end = new Date().getTime();
//        System.out.println("In HashMap: " + (end - begin));
//
//        begin = new Date().getTime();
//        for (int i = 0; i < 1000000; i++) {
//            catalog.findItemByIDAL(10);
//        }
//        end = new Date().getTime();
//        System.out.println("In ArrayList: " + (end - begin));
//
//        CatalogLoader loader = new CatalogStubLoader();
//        loader.load(catalog);
//        System.out.println();
//        catalog.printItems();
    
    
    }
}