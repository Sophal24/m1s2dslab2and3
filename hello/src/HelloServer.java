
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer {

	public static void main(String[] args) {
		try {
			// Create a Hello remote object
			HelloImpl h = new HelloImpl("Welcome ");
			Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);

			// Register the remote object in RMI registry with a given identifier
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("HelloService", h_stub);

			System.out.println("Server ready");

		} catch (Exception e) {
			System.err.println("Error on server :" + e);
			e.printStackTrace();
		}
	}
}
