import java.rmi.*;
import java.rmi.registry.*;
public class Client{
public static void main(String args[]) throws Exception{
   Registry registry=LocateRegistry.getRegistry(7777);
Add obj=(Add)registry.lookup("Add");
int n=obj.add(10,20);
System.out.println("Addition is:"+n);
}
}