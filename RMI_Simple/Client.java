import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try {
	    Registry registry = LocateRegistry.getRegistry(null);
	    Hello stub = (Hello) registry.lookup("Hello");

            stub.printMsg();
	} catch (Exception e) {
	    System.err.println("client exception: " + e.toString());
	}
    }
}
