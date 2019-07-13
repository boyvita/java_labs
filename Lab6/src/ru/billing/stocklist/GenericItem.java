package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    static int currentID = 0;
    Category category = Category.GENERAL;
    
    protected int ID; // ID товара
    protected String name; // Наименование товара
    protected float price; //Цена товара
    protected GenericItem analogItem;
    
    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public GenericItem getAnalogItem() {
        return analogItem;
    }
    
    
    public void setID(int ID) { this.ID = ID; }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setAnalogItem(GenericItem analogItem) {
        this.analogItem = analogItem;
    }
    
    
    public GenericItem(String name, float price, Category category) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public GenericItem(String name, float price, GenericItem analog) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analogItem = analog;
    }
    
    public GenericItem() {
        this("Unnamed", 0, Category.GENERAL);
    }
    
    public void printAll() {
        System.out.println(this.toString());
    }
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GenericItem g = (GenericItem) obj;
        return this.ID == g.ID && this.name == g.name && this.price == g.price && this.category == g.category && this.analogItem == g.analogItem;
    }
    
    @Override
    public Object clone()
            throws CloneNotSupportedException {
        GenericItem g = (GenericItem) super.clone();
        if (this.analogItem != null) {
            g.analogItem = (GenericItem) this.analogItem.clone();
        }
        return g;
    }
    
    public String toString() {
        return String.format("ID: %d, Name: %s, price:%5.2f, category: %s", ID, name, price, category);
    }
}
