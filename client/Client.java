import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry(8000);
            Product laptop = (Product) registry.lookup("laptop");
            String laptopName = laptop.getName();
            String laptopDescription = laptop.getDescription();
            Double laptopPrice = laptop.getPrice();
            System.out.println("The laptop name is: " + laptopName);
            System.out.println("The laptop price is: " + laptopPrice);
            System.out.println("The laptop description is: " + laptopDescription);
        } catch (Exception e) {
            System.out.println("error:" + e);
        }
    }
}