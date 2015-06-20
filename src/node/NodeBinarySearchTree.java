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

	public String toString(int level) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<level;i++)
			sb.append(" ");
		sb.append(this.toString());
		sb.append("\n");
		
		if(this.left!=null)
			sb.append(this.left.toString(level+1));
		else
		{
			for(int i=0;i<level+1;i++)
				sb.append(" ");
			sb.append("()\n");
		}
		if(this.right!=null)
			sb.append(this.right.toString(level+1));
		else
		{
			for(int i=0;i<level+1;i++)
				sb.append(" ");
			sb.append("()\n");
		}
		return sb.toString();
	}
}
