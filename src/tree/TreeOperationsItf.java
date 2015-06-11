package tree;

public interface TreeOperationsItf<T> {

	public void insert(T e);
	
	public void delete(T e);
	
	public boolean search(T e);
	
	public boolean isEmpty();
	
	
	
}
