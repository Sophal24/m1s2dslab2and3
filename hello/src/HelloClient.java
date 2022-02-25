import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class HelloClient implements Info_itf {

	// Declare Variables
	private String name;

	// Constructor
	public HelloClient(String name) {
		this.name = name;
	}

	// Methods
	public String getName() throws RemoteException {
		return name;
	}

	public static void main(String[] args) {

		try {
			if (args.length < 1) {
				System.out.println("Usage: java HelloClient <rmiregistry host>");
				return;
			}

			String host = args[0];

			// Get remote object reference
			Registry registry = LocateRegistry.getRegistry(host);
			Hello h = (Hello) registry.lookup("HelloService");

			// Remote method invocation
			Scanner input = new Scanner(System.in);
			System.out.print("Input your name and Enter: ");
			String name = input.nextLine();
			input.close();

			Info_itf getClientName = new HelloClient(name);
			Info_itf clientName = (Info_itf) UnicastRemoteObject.exportObject(getClientName, 0);

			String res = h.sayHello(clientName);
			System.out.println(res);

		} catch (Exception e) {
			System.err.println("Error on client: " + e);
		}
	}
}