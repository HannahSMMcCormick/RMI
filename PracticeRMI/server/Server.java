
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server {
    
    public static void main(String [] args ){

        try{


            System.setProperty("java.rmi.Server.hostname","127.0.0.1");

            ProductImpl p1 = new  ProductImpl("Phone", "Samsung Galaxy S24 Ultra", 1200);
            ProductImpl p2 = new  ProductImpl("Controller", "Xbox controller", 50);
            ProductImpl p3 = new  ProductImpl("Speaker", "Divoom Ditoo",70);
            ProductImpl p4 = new  ProductImpl("Console", "Nintendo Switch", 250);

           Product stub1 =  (Product) UnicastRemoteObject.exportObject(p1, 0);
           Product stub2 =  (Product) UnicastRemoteObject.exportObject(p2, 0);
           Product stub3 =  (Product) UnicastRemoteObject.exportObject(p3, 0);
           Product stub4 =  (Product) UnicastRemoteObject.exportObject(p4, 0);



            Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);

            registry.rebind("p",stub1);
            registry.rebind("c",stub2);
            registry.rebind("b",stub3);
            registry.rebind("g",stub4);

        } catch(Exception e) {


            System.out.println("Sorry server error..." + e);

        }

}

}
