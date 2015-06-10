package list;

import org.junit.Before;

public class UnrolledLinkedListTest extends LinkedListTest {
	
	@Override
	@Before
	public void setUp()
	{
		testListInteger = new UnrolledLinkedList<Integer>();
		l2              = new UnrolledLinkedList<Integer>();
	}
}
