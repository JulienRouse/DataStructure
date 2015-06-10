package node;

/**
 * 
 * @author superancetre
 *
 * @param <T> 
 */
public class NodeSimple<T> implements Node<T>
{
	public T val;
	public NodeSimple<T> next;
	
	public NodeSimple(T val)
	{
		this.val = val;
		this.next = null;
	}
	
	public String toString()
	{
		return this.val.toString();
	}
}