import java.util.Date;

public class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TechicalItem) {
            return super.equals(obj) && dateOfIncome == ((FoodItem) obj).dateOfIncome &&
                    expires == ((FoodItem) obj).expires;
        }
        return false;
    }
    
    @Override
    public Object clone()
            throws CloneNotSupportedException {
        FoodItem g = (FoodItem) super.clone();
        g.dateOfIncome = (Date) this.dateOfIncome.clone();
        g.expires = this.expires;
        return g;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, price: %5.2f, category: %s, income date: %s, days left: %d", ID, name, price, category, dateOfIncome.toString(), expires);
    }
    
}
