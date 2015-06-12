package node;



public class NodeBinarySearchTree<T extends Comparable<T>> {
	
	public T key;
	public NodeBinarySearchTree<T> left;
	public NodeBinarySearchTree<T> right;
	
	public NodeBinarySearchTree(T e)
	{
		this.key = e;
		this.left=null;
		this.right=null;
	}
	
	public String toString()
	{
		return this.key.toString();
	}
}
