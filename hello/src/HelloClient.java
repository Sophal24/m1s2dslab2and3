import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class HelloClient {
  public static void main(String [] args) {
	
	try {
	  if (args.length < 1) {
	   System.out.println("Usage: java HelloClient <rmiregistry host>");
	   return;}

	String host = args[0];

	// Get remote object reference
	Registry registry = LocateRegistry.getRegistry(host); 
	Hello h = (Hello) registry.lookup("HelloService");

	// Remote method invocation

	Scanner input = new Scanner(System.in); //System.in is a standard input stream  
	System.out.print("Input Client Name: ");  
	String clientName = input.nextLine();   //reads string

	String res = h.sayHello(clientName);
	System.out.println(res);

	} catch (Exception e)  {
		System.err.println("Error on client: " + e);
	}
  }
}