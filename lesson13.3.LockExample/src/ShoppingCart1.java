

public class ShoppingCart1 {
     
    public synchronized void addItem(Object o) {
        // modify shopping cart
    }
     public synchronized String getSummary() {
        String s = "";
        // read cart, modify s
        return s;
    }
    public synchronized double getTotal() {
        double total = 0;
        // read cart, add everything to total
        return total;
    }
}