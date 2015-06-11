package list;


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

	
	
}
