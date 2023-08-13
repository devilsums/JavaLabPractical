import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    protected ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getGreeting() throws RemoteException {
        return "Hello client, server started";
    }

    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("Server", server);
            System.out.println("Server started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
