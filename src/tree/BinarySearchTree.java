package tree;

import node.NodeBinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements TreeOperationsItf<T> {

	public T root;
	
	public BinarySearchTree(T root)
	{
		this.root = root;
	}

	@Override
	public void insert(T e) {
		NodeBinarySearchTree<T> tmp = this.root;
		
		if(this.root.compareTo(e)<0)
			return;
			
		
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
