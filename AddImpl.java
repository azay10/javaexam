import java.rmi.server.*;
public class AddImpl extends UnicastRemoteObject implements Add{
public AddImpl() throws Exception{
super();
}
public int add(int x,int y){
return x+y;
}
}
