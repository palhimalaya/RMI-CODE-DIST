import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            ProductImp p1 = new ProductImp("laptop", "top", 80000);
            ProductImp p2 = new ProductImp("Mobile", "samsung", 40000);
            ProductImp p3 = new ProductImp("Desktop", "cg", 60000);
            ProductImp p4 = new ProductImp("Hard Disk", "2TB", 10000);

            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1, 0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2, 0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3, 0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4, 0);

            Registry registry = LocateRegistry.createRegistry(8000);
            System.out.println("Server is ready");
            registry.rebind("laptop", stub1);
            registry.rebind("Mobile", stub2);
            registry.rebind("Desktop", stub3);
            registry.rebind("Hard Disk", stub4);
        } catch (Exception e) {
            System.out.println("Server error " + e);
        }
        ;
    }
    // palhimalaya
}