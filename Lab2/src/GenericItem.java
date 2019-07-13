import java.io.*;

public class GenericItem implements Cloneable {
    public int ID; // ID товара
    public String name; // Наименование товара
    public float price; //Цена товара
    public GenericItem analogItem;
    Category category = Category.GENERAL;
    
    void printAll() {
        System.out.println(this.toString());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericItem g = (GenericItem) obj;
        return this.ID == g.ID && this.name == g.name && this.price == g.price && this.category == g.category &&
                this.analogItem == g.analogItem;
    }
    
    @Override
    public Object clone()
            throws CloneNotSupportedException {
        GenericItem g = (GenericItem) super.clone();
        
        if (this.analogItem != null) {
            g.analogItem = this.analogItem;
        }
        return g;
    }
    
    public static Object copy(Object orig) {
        Object obj = null;
        Object obj1 = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.writeObject(((GenericItem)orig).analogItem);
    
            out.flush();
            out.close();
            
            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
            obj1 = in.readObject();
            obj
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }
    
    public String toString() {
        return String.format("ID: %d, Name: %s, price:%5.2f, category: %s", ID, name, price, category);
    }
}
