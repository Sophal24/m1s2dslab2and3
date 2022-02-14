
import java.rmi.*;

public  class HelloImpl implements Hello {

	private String message;
 
	public HelloImpl(String s) {
		message = s ;
	}

	public String sayHello(String clientName) throws RemoteException {
		String result = message + " " + clientName;
		System.out.println("Client Name: " + clientName);
		return result;
	}
}

