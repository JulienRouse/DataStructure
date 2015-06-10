package list;

import node.Node;
import node.NodeSimple;

/**
 * The interface describing a List.
 * 
 * 
 * @author Julien Rousé
 *
 * @param <T> The type of element held in this collection.
 */
public abstract class ListAbs<T> {

	
	public NodeSimple<T> head;
	public int size;
	
	/**
	 * Insert the specified element at the specified index(index is starting from 0, like arrays). 
	 * <p>
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param e Is the element to insert into the list.
	 * @param index The index at which the specified element will be inserted.
	 * @return Nothing
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size())
	 */
	public abstract void add(T e, int index);
	
	/**
	 * Insert the specified element at the beginning of this list.
	 * @param e The element to insert.
	 */
	public abstract void prepend(T e);
	
	/**
	 * Insert the specified element at the end of this list.
	 * @param e The element to insert.
	 */
	public abstract void append(T e);
	
	/**
	 * Removes
	 * @param index
	 * @throws NoSuchElementException If the list is empty.
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size())
	 */
	public abstract void remove(int index);
	
	/**
	 * Removes the first element of the list
	 * 
	 *@throws NoSuchElementException If the list is empty.
	 */
	public abstract void removeHead();
	
	/**
	 * Removes the last element of the list
	 */
	public abstract void removeLast();
	
	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param e Element whose presence in this list is to be tested.
	 * @return True if this list contains the specified element.
	 */
	public abstract boolean contains(T e);
	
	/**
	 * Returns true if this list contains no elements. 
	 * 
	 * @return True if the list is empty, False otherwise.
	 */
	public boolean isEmpty()
	{
		return (this.size()==0);
	}
	
	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return The number of elements in this list.
	 */
	public int size()
	{
		return this.size;
	}
	/**
	 * Returns the head of the list without modifying the list
	 * , null if the list is empty
	 * @return The head of the list.
	 */
	public abstract T head();
	
	/**
	 * Returns the tail of the list( all of it except the head element),
	 * null if the list is empty or contain only one element.
	 * @return The tail of the list.
	 */ 
	public abstract ListAbs<T> tail();
	
	/**
	 * Returns the element at the specified index
	 * @param index Index of the element to return.
	 * @return The element at the specified index.
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size())
	 */
	public abstract T get(int index);
	
	/**
	 * Replaces the element at the specified index in this list by the specified element.
	 * @param e Element to be inserted in the list.
	 * @param index Index of the element to replace
	 * @return The element previously at the specified index
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size())
	 */
	public abstract T set(T e,int index);
	
	public Node<T> getNthNode(int index)
	{
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		NodeSimple<T> tmp = this.head;
		for(int i=0;i<index;i++)
			tmp = tmp.next;
		
		return tmp;
	}
	
	public boolean equals(ListAbs<T> l)
	{
		boolean res=false;
		if(this.head==null && l.head==null)
			return true;
		if (this.size()==l.size())
		{
			NodeSimple<T> nodeThis = this.head;
			NodeSimple<T> nodeL    = l.head;
			res = true;
			while(nodeThis!=null)
			{
				if(this.head.val!=l.head.val)
					return false;
				nodeThis = nodeThis.next;
				nodeL    = nodeL.next;
			}
		}
		return res;
	}
	
}
