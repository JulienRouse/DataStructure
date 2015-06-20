package tree;

import java.util.NoSuchElementException;

import list.LinkedList;
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
				BinarySearchTree<T> leftTree = new BinarySearchTree<T>(tmp.left);
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
	//Should that be contain?
	public boolean search(T e) {
		if(this.isEmpty())
			throw new NoSuchElementException("The tree is empty");
		
		NodeBinarySearchTree<T> tmp = this.root;
		if(tmp.key.compareTo(e)==0)
			return true;
		else if(tmp.key.compareTo(e)<0)
		{
			if(tmp.right!=null)
			{
				BinarySearchTree<T> rightTree = new BinarySearchTree<T>(tmp.right);
				return rightTree.search(e);
			}
			else
				return false;
		}
		else if(tmp.key.compareTo(e)>0)
		{
			if(tmp.left!=null)
			{
				BinarySearchTree<T> leftTree = new BinarySearchTree<T>(tmp.left);
				return leftTree.search(e);
			}
			else
				return false;
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.root==null;
	}
	
	@Override
	public String toString()
	{
		if(this.isEmpty())
			return "";
		return this.root.toString(0);
	}
	
	/**
	 * Returns a sorted list from a specified list.
	 * @param list The list to be sorted
	 * @return A sorted list
	 */
	public  LinkedList<T> sortFromList(LinkedList<T> list)
	{
		//creating the bst
		BinarySearchTree<T> bst = new BinarySearchTree<T>(list.head());
		for(int i=1;i<list.size();i++)
			bst.insert(list.get(i));
		
		//
		
		
		return null;
	}
	
	
	
}
