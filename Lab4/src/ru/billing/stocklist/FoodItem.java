package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    
    private Date dateOfIncome;
    private short expires;
    
    public Date getDateOfIncome() {
        return dateOfIncome;
    }
    
    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }
    
    public short getExpires() {
        return expires;
    }
    
    public void setExpires(short expires) {
        this.expires = expires;
    }
    
    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.name = name;
        this.price = price;
        this.analogItem = analog;
        this.dateOfIncome = date;
        this.expires = expires;
        this.category = Category.FOOD;
    }
    
    public FoodItem(String name, float price, short expires) {
        this(name, price, null, new Date(), expires);
    }
    
    public FoodItem(String name) {
        this(name, 0, null, new Date(), (short) 0);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FoodItem) {
            return super.equals(obj) && dateOfIncome == ((FoodItem) obj).dateOfIncome && expires == ((FoodItem) obj).expires;
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
