
import java.rmi.*;

public  class HelloImpl implements Hello {

	private String message;
 
	public HelloImpl(String s) {
		message = s ;
	}

	public String sayHello(Info_itf client) throws RemoteException {
		String result = message + " " + client.getName();
		// System.out.println("Client Name: " + client);
		return result;
	}
}

