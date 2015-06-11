package list;

import java.util.NoSuchElementException;


import node.NodeSimple;

public class LinkedList<T> extends ListAbs<T> {

	
	public LinkedList()
	{
		super();
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
		if(index==this.size())
		{
			this.append(e);
			return ;
		}
		
		
		NodeSimple<T> newNode = new NodeSimple<T>(e);
		NodeSimple<T> tmp = this.head;
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
		NodeSimple<T> newNode = new NodeSimple<T>(e);
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
		NodeSimple<T> lastNode = this.head;
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
			
			lastNode.next = new NodeSimple<T>(e);
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
			removeHead();
			return;
		}
		NodeSimple<T> tmp = this.head;
		for(int i=0;i<index-1;i++)
			tmp = tmp.next;
		tmp.next = tmp.next.next;
		this.size--;
	}

	@Override
	public void removeHead() {
		if(this.isEmpty())
			throw new NoSuchElementException("The list is empty");
		
		this.head = this.head.next;
		this.size--;
	}

	@Override
	public void removeLast() {
		if(this.isEmpty())
			throw new NoSuchElementException("The list is empty");
		
		if(this.size()==1)
		{
			this.head = null;
		}
		else
		{
			NodeSimple<T> newNode = this.head;
			for(int i=0;i<this.size()-2;i++)
				newNode = newNode.next;
			newNode.next = null;
		}
		this.size--;
	}

	@Override
	public boolean contains(T e) {
		NodeSimple<T> tmp = this.head; 
		while(tmp!=null)
		{
			if(tmp.val.equals(e))
				return true;
			tmp = tmp.next;
		}
		return false;
	}
	
	@Override
	public T head() {
		if (this.isEmpty())
			return null;
		
		return this.head.val;
	}

	@Override
	public ListAbs<T> tail() {
		if(this.size()<=1)
			return null;
		LinkedList<T> res = new LinkedList<T>();
		res.size = this.size-1;
		res.head = this.head.next;
		return res;
	}

	@Override
	public T get(int index) {
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		NodeSimple<T> tmp = this.head;
		for(int i=0;i<index;i++)
			tmp = tmp.next;
		
		return tmp.val;
	}


	@Override
	public T set(T e, int index) {
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		NodeSimple<T> tmp = this.head;
		T res = null;
		
		for(int i=0;i<index;i++)
			tmp = tmp.next;
		res = tmp.val;
		tmp.val = e;
		
		return res;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (this.head != null)
		{
			sb.append(this.head.val);
			NodeSimple<T> n = this.head;
			for(int i=this.size()-1;i>0;i--)
			{
				n = n.next;
				sb.append(",");
				sb.append(n.val);
				
			}
		}
		sb.append("]");
		return sb.toString();
	}
	


	
	
	
}
