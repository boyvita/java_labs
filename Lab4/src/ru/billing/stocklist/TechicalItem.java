package ru.billing.stocklist;

public class TechicalItem extends GenericItem {
    public short warrantyTime;
    
    public short getWarrantyTime() {
        return warrantyTime;
    }
    
    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TechicalItem) {
            return super.equals(obj) && warrantyTime == ((TechicalItem) obj).warrantyTime;
        }
        return false;
    }
    
    @Override
    public Object clone()
            throws CloneNotSupportedException {
        TechicalItem g = (TechicalItem) super.clone();
        g.warrantyTime = this.warrantyTime;
        return g;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, price: %5.2f, category: %s, warranty days: %d",
                ID, name, price, category, warrantyTime);
    }
    
   
}
