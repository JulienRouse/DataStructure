package list;

public abstract class SelfOrganizingList<T> extends LinkedList<T>{

	//TODO should i use selfOrganize for set() too? Or for any other method?
	@Override
	public T get(int index)
	{
		T tmp = super.get(index);
		selfOrganize(index);
		return tmp;
	}
	
	/**
	 * Method to change the ordering of the list, based on an heuristic.
	 * 
	 * @param index Index to the node to selfOrganize if the heuristic needs it to be organized.
	 * 
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size())
	 */
	public abstract void selfOrganize(int index);
}
