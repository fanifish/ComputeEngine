
/**
*	Task interface which the compute engine will call execute on i.e. all jobs must impliment this interface
*/
public interface Task<T> {
    T execute();
}
