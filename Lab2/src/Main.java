import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)
            throws ParseException, CloneNotSupportedException {
        GenericItem gi1 = new GenericItem();
        GenericItem gi2 = new GenericItem();
        GenericItem gi3 = new GenericItem();
        gi1.ID = 1;
        gi1.name = "paper";
        gi1.price = 1;
        gi2.ID = 2;
        gi2.name = "cup";
        gi2.price = 70;
        gi3.ID = 3;
        gi3.name = "fork";
        gi3.price = 50;
        
        gi1.printAll();
        gi2.printAll();
        gi3.printAll();
        
        FoodItem fi1 = new FoodItem();
        FoodItem fi2 = new FoodItem();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        fi1.ID = 4;
        fi1.name = "Cheese";
        fi1.price = 90;
        fi1.category = Category.FOOD;
        fi1.dateOfIncome = dateformat.parse("01/3/2019");
        fi1.expires = 7;
        fi2.ID = 5;
        fi2.name = "Milk";
        fi2.price = 70;
        fi2.category = Category.FOOD;
        fi2.dateOfIncome = dateformat.parse("08/3/2019");
        fi2.expires = 4;
        
        TechicalItem ti1 = new TechicalItem();
        TechicalItem ti2 = new TechicalItem();
        TechicalItem ti3 = new TechicalItem();
        ti1.ID = 6;
        ti1.name = "Sofa";
        ti1.price = 5000;
        ti1.warrantyTime = 365;
        ti2.ID = 7;
        ti2.name = "Vacuum cleaner";
        ti2.price = 7000;
        ti2.warrantyTime = 720;
        ti3.ID = 8;
        ti3.name = "Lamp";
        ti3.price = 2000;
        ti3.warrantyTime = 180;
        ti3.analogItem = ti1;
        
        GenericItem[] items = {fi1, fi2, ti1, ti2, ti3};
        System.out.println();
        for (int i = 0; i < items.length; i++) {
            items[i].printAll();
        }
        
        System.out.println();
        System.out.println("ti1.equals(ti2): " + ti1.equals(ti2));
        System.out.println("ti1.equals(ti1): " + ti1.equals(ti1));
        System.out.println("ti1.equals(ti1.clone()): " + ti1.equals(ti1.clone()));
        
        TechicalItem ti4 = (TechicalItem) ti3.clone();
        System.out.println("TechicalItem ti4 = (TechicalItem) ti3.clone();");
        System.out.println("ti4: " + ti4);
        System.out.println("ti4.analogItem: " + ti4.analogItem);
        ti4.analogItem = ti2;
        System.out.println("ti4.analogItem = ti2;");
        System.out.println("ti4.analogItem: " + ti4.analogItem);
        
    }
}