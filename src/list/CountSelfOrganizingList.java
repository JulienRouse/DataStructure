package list;


import node.NodeSimple;
import node.NodeSimpleCount;

public class CountSelfOrganizingList<T> extends SelfOrganizingList<T> {

	public NodeSimpleCount<T> head;
		
	@Override
	public void selfOrganize(int index) {
		//The node is already at the head so no reordering
		if (index==0)
			return;
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Index not appropriate: "+index);		
		
		
		NodeSimpleCount<T> nodeToChange = (NodeSimpleCount<T>) getNthNode(index);
 		NodeSimpleCount<T> nodeBefore   = (NodeSimpleCount<T>) getNthNode(index-1);
 		
 		if(nodeToChange.count+1>=nodeBefore.count)
 		{
			nodeBefore.next=nodeToChange.next;
			nodeToChange.next=nodeBefore;
	 		if(index==1)
	 		{
	 			this.head=nodeToChange;
	 		}
	 		else
	 		{
	 			NodeSimpleCount<T> nodeBeforeBefore = (NodeSimpleCount<T>) getNthNode(index-2);
	 			nodeBeforeBefore.next = nodeToChange;
	 		}
	 		selfOrganize(index-1);
	 		return;
 		}
 		nodeToChange.count++;
	}

	@Override
	public void add(T e,int index)
	{
		if (index<0 || index>this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		if(index==0)
		{
			this.prepend(e);
			return ;
		}
		if(index==this.size())
		{
			this.append(e);
			return ;
		}
		
		
		NodeSimpleCount<T> newNode = new NodeSimpleCount<T>(e);
		NodeSimpleCount<T> tmp = this.head;
		for(int i=0;i<index-1;i++)
		{
			tmp =  tmp.next;
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
		this.size++;
	}
	
	@Override
	public void prepend(T e) {
		NodeSimpleCount<T> newNode = new NodeSimpleCount<T>(e);
		if (this.isEmpty())
		{
			this.head = newNode;
			
		}
		else
		{
			newNode.next = this.head;
			this.head = newNode;
		}
		this.size++;
	}

	@Override
	public void append(T e) {
		NodeSimpleCount<T> lastNode = this.head;
		if(this.isEmpty())
		{
			prepend(e);
		}
		else
		{
			while(lastNode.next!=null)
			{
				lastNode = lastNode.next;
			}
			
			lastNode.next = new NodeSimpleCount<T>(e);
			this.size++;
		}
		
	}
	
	
}
