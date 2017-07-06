
package example.com;

public class StaticCounterClass {    
    private static int counter = 0;
    
    {
        System.out.println("Building");
    }
    
    public StaticCounterClass() {
        System.out.println("creating instance...");
        counter++;
    }
    
    public static int getCount() {
        return counter;
    }
}