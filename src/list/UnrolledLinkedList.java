package list;

import java.util.NoSuchElementException;

import exception.MaximumCapacityReachedException;
import node.NodeArray;



public class UnrolledLinkedList<T> extends ListAbs<T> 
{

	public NodeArray<T> head;
	
	public UnrolledLinkedList()
	{
		this.head = null;
		this.size = 0;
	}
	
	
	@Override
	public void add(T e, int index) {
		if (index<0 || index>this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		if(index==0)
		{
			this.prepend(e);
			return ;
		}
		else if(index==this.size())
		{
			this.append(e);
			return ;
		}
		else
		{
			//we look for the node that will contain the element at the index
			NodeArray<T> tmp = this.head;
			int elemCount = tmp.numElements;
			while(elemCount<index)
			{
				tmp=tmp.next;
				elemCount+=tmp.numElements;
			}
			//we convert the global index to the index of this particular node
			int localIndex = tmp.numElements-(elemCount-index)-1;
			try {
				tmp.add(e,localIndex);
			} catch (MaximumCapacityReachedException e1) {
				elemCount-=tmp.numElements;
				NodeArray<T> newNode = tmp.splitAfter();
				newNode.next = tmp.next;
				tmp.next = newNode;
				if(elemCount+tmp.numElements>=index)
				{
					localIndex = tmp.numElements-(elemCount-index)-1;
					try {
						tmp.add(e, localIndex);
					} catch (MaximumCapacityReachedException e2) {
						throw new Error();
						//we should never go there, cause we insert into a half-full array
					}
				}
				else
				{
					localIndex = newNode.numElements-(elemCount-index)-1;
					try {
						newNode.add(e, localIndex);
					} catch (MaximumCapacityReachedException e2) {
						throw new Error();
						//we should never go there, cause we insert into a half-full array
					}
				}
			}
			this.size++;
		}
		
		
		
		
	}

	@Override
	public void prepend(T e) {
		if (this.isEmpty())
		{
			this.head = new NodeArray<T>();
			try {
				this.head.append(e);
			} catch (MaximumCapacityReachedException e1) {
				throw new Error();
				//we should never go there, cause we insert into a newly created NodeArray
			}
			this.size++;
		}
		else
		{
			try{
				this.head.prepend(e);
			}
			catch(MaximumCapacityReachedException ex)
			{
				NodeArray<T> newNode = this.head.splitAfter();
				newNode.next = this.head.next;
				this.head.next = newNode;
				try {
					this.head.prepend(e);
				} catch (MaximumCapacityReachedException e1) {
					throw new Error();
					//we should never go there, cause we insert into a half-full array
				}
				this.size++;
			}
		}
	}

	@Override
	public void append(T e) {
		if(this.isEmpty())
		{
			this.prepend(e);
			return;
		}
		else
		{
			NodeArray<T> tmp = this.head;
			while(tmp.next!=null)
				tmp=tmp.next;
			try {
				tmp.append(e);
			} catch (MaximumCapacityReachedException e1) {
				NodeArray<T> newNode = tmp.splitAfter();
				tmp.next = newNode;
				try{
					newNode.append(e);
				}catch(MaximumCapacityReachedException e2) {
					throw new Error();
					//we should never go there, cause we insert into a half-full array
				}
				
			}
			this.size++;
		}
	}

	@Override
	public void remove(int index) {
		if(this.isEmpty())
			throw new NoSuchElementException("The list is empty");
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		if(index==0)
		{
			this.removeHead();
			return;
		}
		//we look for the node that will contain the element at the index
		NodeArray<T> tmpPrevious = null;
		NodeArray<T> tmp = this.head;
		int elemCount = tmp.numElements;
		while(elemCount<index)
		{
			tmpPrevious = tmp;
			tmp=tmp.next;
			elemCount+=tmp.numElements;
		}
		//we convert the global index to the index of this particular node
		int localIndex = tmp.numElements-(elemCount-index)-1;
		tmp.remove(localIndex);
		//if the node is empty, we trash it
		if (tmp.isEmpty())
			tmpPrevious.next = tmp.next;
		this.size--;
	}

	@Override
	public void removeHead() {
		if(this.isEmpty())
			throw new NoSuchElementException("The list is empty");
		
		this.head.removeHead();
		this.size--;
		
		//we clear the node if its empty
		if (this.head.isEmpty())
		{
			if(this.head.next==null)
				this.head=null;
			else
				this.head=this.head.next;
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty())
			throw new NoSuchElementException("The list is empty");
		
		NodeArray<T> tmp = this.head;
		while(tmp.next!=null)
		{	
			//if after the removal the last node would be empty, we just trash the node
			if(tmp.next!=null && tmp.next.next==null &&  tmp.next.numElements<=1)
			{
				tmp.next=null;
				this.size--;
				return;
			}
			tmp=tmp.next;
		}
		tmp.removeLast();
		this.size--;
	}

	@Override
	public boolean contains(T e) {
		if(this.isEmpty())
			return false;
		
		NodeArray<T> tmp = this.head;
 		while(tmp!=null)
 		{
 			if(tmp.contains(e))
 				return true;
 			tmp=tmp.next;
 		}
		return false;
	}

	@Override
	public T head() {
		if(this.isEmpty() || this.head.isEmpty())
			return null;
		return this.head.head();
	}

	@Override
	public ListAbs<T> tail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) {
		if (index<0 || index>this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		//we look for the node that will contain the element at the index
		NodeArray<T> tmp = this.head;
		int elemCount = tmp.numElements;
		while(elemCount<index)
		{
			tmp=tmp.next;
			elemCount+=tmp.numElements;
		}
		//we convert the global index to the index of this particular node
		int localIndex = tmp.numElements-(elemCount-index)-1;
		return tmp.get(localIndex);
	}

	@Override
	public T set(T e, int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (this.head != null)
		{
			sb.append(this.head.toString());
			NodeArray<T> node = this.head;
			
			while(node.next!=null)
			{
				node = node.next;
				sb.append(",");
				sb.append(node.toString());
			}
		}
		sb.append("]");
		return sb.toString();
	}
	

}
