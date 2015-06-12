package tree;

import exception.AlreadyPresentException;
import node.NodeBinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements TreeOperationsItf<T> {

	public NodeBinarySearchTree<T> root;
	
	
	public BinarySearchTree(NodeBinarySearchTree<T> root)
	{
		this.root = root;
	}
	
	public BinarySearchTree(T e) {
		this.root = new NodeBinarySearchTree<T>(e);
	}

	@Override
	public void insert(T e) {
		if(this.isEmpty())
			this.root = new NodeBinarySearchTree<T>(e);
		
		NodeBinarySearchTree<T> tmp = this.root;
		
		//if e>tmp.value
		if(tmp.key.compareTo(e)<0)
		{
			if(tmp.right==null)
				tmp.right = new NodeBinarySearchTree<T>(e);
			else
			{
				BinarySearchTree<T> rightTree = new BinarySearchTree<T>(tmp.right);
				rightTree.insert(e);
				return;
			}
		}//if e<tmp.value
		else if (tmp.key.compareTo(e)>0)
		{
			if(tmp.left==null)
				tmp.left=new NodeBinarySearchTree<T>(e);
			else
			{
				BinarySearchTree<T> leftTree = new BinarySearchTree<T>(tmp.right);
				leftTree.insert(e);
				return;
			}
		} else
			try {
				throw new AlreadyPresentException();
			} catch (AlreadyPresentException e1) {
				System.out.println(e.toString()+" already in the tree");
			}
		
	}

	@Override
	public void delete(T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean search(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.root==null;
	}
	
	
}
