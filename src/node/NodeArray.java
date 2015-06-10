package node;

import java.util.NoSuchElementException;

import exception.MaximumCapacityReachedException;
import exception.NotEnoughElementRuntimeException;

public class NodeArray<T> implements Node<T>
{
	private int ARRAYSIZE;;
	public T[] elements;
	public NodeArray<T> next;
	public int numElements;
	
	@SuppressWarnings("unchecked")
	public NodeArray()
	{
		this.ARRAYSIZE=64;
		this.elements = (T[])new Object[ARRAYSIZE];
		this.next = null;
		this.numElements = 0;
	}
	
	public NodeArray(int arraySize)
	{
		this();
		this.ARRAYSIZE=arraySize;
	}
	
	
	/**
	 * Inserts an element at the first free space in this array.
	 * @param e Element to be inserted.
	 * @throws MaximumCapacityReachedException When the array is full and need a split.
	 * 
	 */
	public void append(T e) throws MaximumCapacityReachedException
	{
		if(this.isFull())
			throw new MaximumCapacityReachedException();
		
		this.elements[this.numElements] = e;
		this.numElements++;
	}
	
	/**
	 * Inserts an element at the beginning of the array, shifting every other element to the right.
	 * @param e Element to be inserted.
	 * @throws MaximumCapacityReachedException When the array is full and need a split.
	 * 
	 */
	public void prepend(T e) throws MaximumCapacityReachedException
	{
		if(this.isFull())
			throw new MaximumCapacityReachedException();
		
		//possible cause we know the array isnt full
		for(int i=this.numElements-1;i>=0;i--)
			this.elements[i+1] = this.elements[i];
		this.elements[0] = e;
		this.numElements++;
	}
	
	/**
	 * Inserts an element at the specified index in the array, shifting every element after this one to the right.
	 * @param e The element to be inserted.
	 * @param index The specified index to place the element.
	 * @throws MaximumCapacityReachedException When the array is full and need a split.
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= numElement)
	 */
	public void add(T e,int index) throws MaximumCapacityReachedException
	{
		if (index<0 || index>this.numElements)
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		if(this.isFull())
			throw new MaximumCapacityReachedException();
		
		//possible cause we know the array isnt full
		for(int i=this.numElements;i>=index;i--)
			this.elements[i+1] = this.elements[i];
		this.elements[index] = e;
		this.numElements++;
	}
	
	/**
	 * Removes the element at the specified index
	 * @param index
	 * @throws NoSuchElementException If the array is empty
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= numElement)
	 */
	public void remove(int index) {
		if(this.isEmpty())
			throw new NoSuchElementException("The array is empty");
		
		if (index<0 || index>=this.numElements)
			throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		for(int i=index+1;i<this.numElements;i++)
			this.elements[i-1] = this.elements[i];
		this.numElements--;
	}
	
	/**
	 * Removes the first element of this array, and shift every other element to the left.
	 * @throws NoSuchElementException If this array is empty.
	 */
	public void removeHead() {
		if(this.isEmpty())
			throw new NoSuchElementException("The array is empty");
		
		for(int i=1;i<this.numElements;i++)
			this.elements[i-1] = this.elements[i];
		this.numElements--;
	}
	
	/**
	 * Remove the last element of the array.
	 * 
	 * @throws NoSuchElementException If this array is empty.
	 */
	public void removeLast()
	{
		if(this.numElements<=0)
			throw new NoSuchElementException("The array is empty");
		
		this.numElements--;
	}
	
	/**
	 * Take half the elements in this array and put them in a new NodeArray<T>.<p>
	 * If the number of element is odd, the bigger half stay in the NodeArray<T> doing the split.
	 * 
	 * @return The new NodeArray<T>.
	 * @throws NotEnoughElementException 
	 */
	public NodeArray<T> splitAfter() 
	{
		if(this.numElements<this.ARRAYSIZE)
			throw new NotEnoughElementRuntimeException();
		NodeArray<T> newNode = new NodeArray<T>();
		
		//find where the half is, different if ARRAYSIZE is even or odd
		int indexHalf = 0;
		if (this.ARRAYSIZE%2==0)
			indexHalf = this.ARRAYSIZE/2;
		else
			indexHalf = (this.ARRAYSIZE/2)+1;
		
		//migrate half the array in the new node
		for(int i=indexHalf,j=0;i<this.ARRAYSIZE;i++,j++)
		{
			newNode.elements[j] = this.elements[i];
		}
		
		//update the numElement in both Node
		this.numElements = indexHalf;
		newNode.numElements = newNode.ARRAYSIZE - indexHalf;
		
		return newNode;
	}
	
	
	/**
	 * Returns True if the array is full
	 * @return
	 */
	public boolean isFull()
	{
		return (this.numElements>=this.ARRAYSIZE);
	}
	
	/**
	 * Returns the first element of the array, null if there are no element.
	 * @return The first element.
	 */
	public T head()
	{
		if(this.isEmpty())
			return null;
		return this.elements[0];
	}
	
	/**
	 * Returns true if the list is empty.
	 * @return true if the list is empty.
	 */
	public boolean isEmpty() {
		return this.numElements==0;
	}
	
	/**
	 * Tests if the specified element is in this array.
	 * @param e The element to test the presence.
	 * @return True is the element is in this array.
	 */
	public boolean contains(T e) {
		if(this.isEmpty())
			return false;
		
		for(int i=0;i<this.numElements;i++)
			if(e.equals(this.elements[i]))
				return true;
		
		return false;
	}
	
	/**
	 * Returns the element at the specified index
	 * @param index Index of the element to return.
	 * @return The element at the specified index.
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size())
	 */
	/*Note: if i don't call this method, i can't call Integer.intValue() in my tests,
	probably because of:
	    this.elements = (T[])new Object[ARRAYSIZE];
	That was annoying to discover.
	*/
	public T get(int index)
	{
		if (index < 0 || index >= this.numElements)
		throw new IndexOutOfBoundsException("Index is out of the list range: "+index);
		
		return this.elements[index];
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0;i<this.numElements-1;i++)
		{
			sb.append(this.elements[i]);
			sb.append(",");
		}
		sb.append(this.elements[this.numElements-1]);
		sb.append("}");
		return sb.toString();
	}

	

	
}