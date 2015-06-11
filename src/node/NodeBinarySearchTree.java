package node;



public class NodeBinarySearchTree<T extends Comparable<T>> {
	
	public T value;
	public NodeBinarySearchTree<T> left;
	public NodeBinarySearchTree<T> right;
	
	public NodeBinarySearchTree(T e)
	{
		this.value = e;
		this.left=null;
		this.right=null;
	}
}
