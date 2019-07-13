import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)
            throws ParseException, CloneNotSupportedException {
        GenericItem gi1 = new GenericItem("g1", 1, Category.FOOD);
        GenericItem gi2 = new GenericItem("g2", 2, Category.DRESS);
        GenericItem gi3 = new GenericItem("g3", 3, Category.FOOD);
        
        gi1.printAll();
        gi2.printAll();
        gi3.printAll();
    
        String line = "Конфеты ’Маска’;45;120";
        
        String[] item_fld = line.split(";");
        
        FoodItem fi1 = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        fi1.printAll();
        
    }
}