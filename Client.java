import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            ServerInterface server = (ServerInterface) registry.lookup("Server");

            String greeting = server.getGreeting();
            System.out.println("Server response: " + greeting);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
