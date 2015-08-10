import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;

public class ComputePi {
    public static void main(String args[]) {
	System.out.println("Compute pi starting");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
	    System.out.println("Here");
            String name = "Compute";
	    System.out.println("Obtaining the registry");
            Registry registry = LocateRegistry.getRegistry(args[0]);
	    System.out.println("looking up the compute engine");
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
	    System.out.println("######################## DONE ###################");
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
