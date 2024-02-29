import java.rmi.*;
import java.rmi.registry.*;
public class Server{
public static void main(String args[]) throws Exception{
AddImpl obj=new AddImpl();
Registry registry=LocateRegistry.createRegistry(7777);
registry.rebind("Add",obj);
System.out.println("Server Started");
}
}