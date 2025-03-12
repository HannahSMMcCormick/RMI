import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    
    public static void main(String [] args){

        try{

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

        Product Phone = (Product) registry.lookup("p");
        Product Controller = (Product) registry.lookup("c");
        Product Speaker = (Product) registry.lookup("b");
        Product Console = (Product) registry.lookup("g");

        System.out.println(Phone.getName());
        System.out.println(Phone.getDescription());
        System.out.println(Phone.getPrice());

            

        } catch(Exception e){



            System.out.println("Client side error..." + e);



        }


    }



}
