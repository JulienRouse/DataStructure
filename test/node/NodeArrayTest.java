package node;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.MaximumCapacityReachedException;

public class NodeArrayTest {

	NodeArray<Integer> testNodeInteger  = new NodeArray<Integer>(4);
	
	//------------------------------------------------------------------------
	//|append                                                                |
	//------------------------------------------------------------------------
	@Test
	public void testAppendEmpty() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		assertEquals("Should be 42",42,testNodeInteger.head().intValue());
		assertEquals("Shoulb be 1",1,testNodeInteger.numElements);
		}
	
	@Test
	public void testAppendTwo() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		testNodeInteger.append(55);
		assertEquals("Should be 42",42,testNodeInteger.head().intValue());
		assertEquals("Should be 55",55,testNodeInteger.get(1).intValue());
		assertEquals("Shoulb be 2",2,testNodeInteger.numElements);
	}
	
	@Test(expected=MaximumCapacityReachedException.class)
	public void testAppendSplit() throws MaximumCapacityReachedException
	{
		testNodeInteger.append(42);
		testNodeInteger.append(42);
		testNodeInteger.append(42);
		testNodeInteger.append(42);
		testNodeInteger.append(42);
		assertEquals("Should be 4",4,testNodeInteger.numElements);
	}
	//------------------------------------------------------------------------
	//|prepend                                                               |
	//------------------------------------------------------------------------
	@Test
	public void testPrependEmpty() throws MaximumCapacityReachedException {
		testNodeInteger.prepend(42);
		assertEquals("Should be 42",42,testNodeInteger.head().intValue());
		assertEquals("Shoulb be 1",1,testNodeInteger.numElements);
		}
	
	@Test
	public void testPrependTwo() throws MaximumCapacityReachedException {
		testNodeInteger.prepend(42);
		testNodeInteger.prepend(55);
		assertEquals("Should be 55",55,testNodeInteger.head().intValue());
		assertEquals("Should be 42",42,testNodeInteger.get(1).intValue());
		assertEquals("Shoulb be 2",2,testNodeInteger.numElements);
	}
	
	@Test(expected=MaximumCapacityReachedException.class)
	public void testPrependSplit() throws MaximumCapacityReachedException
	{
		testNodeInteger.prepend(42);
		testNodeInteger.prepend(42);
		testNodeInteger.prepend(42);
		testNodeInteger.prepend(42);
		testNodeInteger.prepend(42);
		assertEquals("Should be 4",4,testNodeInteger.numElements);
	}
	//------------------------------------------------------------------------
	//|add                                                                   |
	//------------------------------------------------------------------------
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexBelowZero() throws MaximumCapacityReachedException {
		testNodeInteger.add(42, -1);
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexBeyondSize() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		testNodeInteger.add(42, 42);
	}
	
	@Test
	public void testAddEmpty() throws MaximumCapacityReachedException {
		testNodeInteger.add(42,0);
		assertEquals("Should be 42",42,testNodeInteger.head().intValue());
		assertEquals("Shoulb be 1",1,testNodeInteger.numElements);
		}
	
	@Test
	public void testAddTwo() throws MaximumCapacityReachedException {
		testNodeInteger.add(42,0);
		testNodeInteger.add(55,1);
		assertEquals("Should be 42",42,testNodeInteger.head().intValue());
		assertEquals("Should be 55",55,testNodeInteger.get(1).intValue());
		assertEquals("Shoulb be 2",2,testNodeInteger.numElements);
	}
	
	@Test(expected=MaximumCapacityReachedException.class)
	public void testAddSplit() throws MaximumCapacityReachedException
	{
		testNodeInteger.add(0,0);
		testNodeInteger.add(1,1);
		testNodeInteger.add(2,2);
		testNodeInteger.add(3,1);
		testNodeInteger.add(4,2);
		assertEquals("Should be 4",4,testNodeInteger.numElements);
		assertEquals("Should be 0",0,testNodeInteger.get(0).intValue());
		assertEquals("Should be 3",3,testNodeInteger.get(1).intValue());
		assertEquals("Should be 1",1,testNodeInteger.get(2).intValue());
		assertEquals("Should be 2",2,testNodeInteger.get(3).intValue());
	}
	
	//------------------------------------------------------------------------
	//|remove                                                                |
	//------------------------------------------------------------------------
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|removeHead                                                            |
	//------------------------------------------------------------------------
	@Test
	public void testRemoveHead() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|removeLast                                                            |
	//------------------------------------------------------------------------
	@Test
	public void testRemoveLast() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|splitAfter                                                            |
	//------------------------------------------------------------------------
	@Test
	public void testSplitAfter() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|isFull                                                                |
	//------------------------------------------------------------------------
	@Test
	public void testIsFull() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|head                                                                  |
	//------------------------------------------------------------------------
	@Test
	public void testHead() {
		fail("Not yet implemented");
	}
	//------------------------------------------------------------------------
	//|isEmpty                                                               |
	//------------------------------------------------------------------------
	@Test
	public void testIsEmptyEmpty() {
		assertEquals("Should be true",true,testNodeInteger.isEmpty());
	}
	
	@Test
	public void testIsEmptyOne() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		assertEquals("Should be false",false,testNodeInteger.isEmpty());
	}
	
	@Test
	public void testIsEmptyAppendRemove() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		testNodeInteger.removeHead();
		assertEquals("Should be True",true,testNodeInteger.isEmpty());
	}
	//------------------------------------------------------------------------
	//|contains                                                              |
	//------------------------------------------------------------------------
	@Test
	public void testContainsEmpty() {
		assertEquals("Should be true",false,testNodeInteger.contains(42));
	}
	
	@Test
	public void testContainsOneTrue() throws MaximumCapacityReachedException {
		testNodeInteger.append(42);
		assertEquals("Should be true",true,testNodeInteger.contains(42));
	}
	
	@Test
	public void testContainsOneFalse() throws MaximumCapacityReachedException {
		testNodeInteger.append(55);
		assertEquals("Should be false",false,testNodeInteger.contains(42));
	}
	
	@Test
	public void testContainsManyTrue() throws MaximumCapacityReachedException {
		for(int i=0;i<4;i++)
			testNodeInteger.append(i);
		assertEquals("Should be true",true,testNodeInteger.contains(3));
	}
	
	@Test
	public void testContainsManyFalse() throws MaximumCapacityReachedException {
		for(int i=0;i<4;i++)
			testNodeInteger.append(i);
		assertEquals("Should be false",false,testNodeInteger.contains(42));
	}

}
