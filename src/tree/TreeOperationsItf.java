package tree;

public interface TreeOperationsItf<T> {

	/**
	 * Puts the specified element in the tree.
	 * @param e Element to be inserted into the tree.
	 * @throws AlreadyPresentException If an element in the tree has the same value as the element to be inserted,
	 *                                 throw this exception and don't insert the new element.
	 */
	public void insert(T e);
	
	
	public void delete(T e);
	
	/**
	 * Looks into the tree if it contains the specified element.
	 * 
	 * @param e The element to search into the tree.
	 * @return true if the tree contains the element, false otherwise.
	 * @throws NoSuchElementException
	 */
	public boolean search(T e);
	
	public boolean isEmpty();
	
	public String toString();
	
}
