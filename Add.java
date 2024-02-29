import java.rmi.Remote;
public interface Add extends Remote{
public int add(int x,int y) throws Exception;
}
