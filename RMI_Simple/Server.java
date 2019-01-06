import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplExample {
    public Server () { }

    public static void main(String args[]) {
        try {
            ImplExample obj = new ImplExample();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Hello", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("server exception: " + e.toString());
        }
    }
}

