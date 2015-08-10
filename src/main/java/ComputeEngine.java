import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine extends UnicastRemoteObject implements Compute {

    public ComputeEngine() throws RemoteException {
        super();
    }

    public <T> T executeTask(Task<T> t) {
	System.out.println("Execute");
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
	System.out.println("Staring computengine server");
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
           // Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
	    System.out.println("Obtaining registry");
            Registry registry = LocateRegistry.getRegistry();
	    System.out.println("Binding stub in registry");
            registry.rebind(name, engine);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
