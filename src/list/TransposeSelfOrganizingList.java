package list;

import node.NodeSimple;

public class TransposeSelfOrganizingList<T> extends SelfOrganizingList<T> {

	@Override
	public void selfOrganize(int index) {
		//The node is already at the head so no reordering
		if (index==0)
			return;
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Index not appropriate: "+index);	
		
		NodeSimple<T> nodeToChange = (NodeSimple<T>) getNthNode(index);
 		NodeSimple<T> nodeBefore   = (NodeSimple<T>) getNthNode(index-1);
 		nodeBefore.next=nodeToChange.next;
		nodeToChange.next=nodeBefore;
 		if(index==1)
 		{
 			this.head=nodeToChange;
 		}
 		else
 		{
 			NodeSimple<T> nodeBeforeBefore = (NodeSimple<T>) getNthNode(index-2);
 			nodeBeforeBefore.next = nodeToChange;
 		}
	}

}
