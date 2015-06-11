package list;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class LinkedListTest {
	ListAbs<Integer> testListInteger;
	ListAbs<Integer> l2;
	
	@Before
	public void setUp()
	{
		testListInteger = new LinkedList<Integer>();
		l2 = new LinkedList<Integer>();
	}
	
	//------------------------------------------------------------------------
	//|add                                                                   |
	//------------------------------------------------------------------------
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexBelowZero(){
		testListInteger.add(42, -1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIndexBeyondSize(){
		testListInteger.add(42, 0);
		testListInteger.add(42,1);
		testListInteger.add(42,42);
	}
	
	@Test
	public void testAddEmptyInteger() {
		testListInteger.add(42,0);
		assertEquals("42 should be the first(and only) element",42,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	
	@Test
	public void testAddTwoInteger(){
		testListInteger.add(42,0);
		testListInteger.add(55,1);
		assertEquals("55 should be the second element",55,testListInteger.get(1).intValue());
		assertEquals("The size of the list should be 2",2,testListInteger.size());
	}
	
	@Test
	public void testAddRemoveAddInteger(){
		testListInteger.add(42,0);
		testListInteger.removeHead();
		testListInteger.add(55,0);
		assertEquals("55 should be the first(and only) element",55,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	//------------------------------------------------------------------------
	//|append                                                                |
	//------------------------------------------------------------------------
	@Test
	public void testAppendEmptyInteger() {
		testListInteger.append(42);
		assertEquals("42 should be the first(and only) element",42,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	
	@Test
	public void testAppendTwoInteger(){
		testListInteger.append(42);
		testListInteger.append(55);
		assertEquals("55 should be the second element",55,testListInteger.get(1).intValue());
		assertEquals("The size of the list should be 2",2,testListInteger.size());
	}
	
	@Test
	public void testAppendRemoveAppendInteger(){
		testListInteger.append(42);
		testListInteger.removeHead();
		testListInteger.append(55);
		assertEquals("55 should be the first(and only) element",55,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	//------------------------------------------------------------------------
	//|prepend                                                               |
	//------------------------------------------------------------------------
	
	@Test
	public void testPrependEmptyInteger() {
		testListInteger.prepend(42);
		assertEquals("42 should be the first(and only) element",42,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	
	@Test
	public void testPrependTwoInteger(){
		testListInteger.prepend(42);
		testListInteger.prepend(55);
		assertEquals("55 should be the first element",55,testListInteger.get(0).intValue());
		assertEquals("The size of the list should be 2",2,testListInteger.size());
	}
	
	@Test
	public void testPrependRemovePrependInteger(){
		testListInteger.prepend(42);
		testListInteger.removeHead();
		testListInteger.prepend(55);
		assertEquals("55 should be the first(and only) element",55,testListInteger.head().intValue());
		assertEquals("The size of the list should be 1",1,testListInteger.size());
	}
	
	
	//------------------------------------------------------------------------
	//|remove                                                                |
	//------------------------------------------------------------------------
	@Test(expected=NoSuchElementException.class)
	public void testRemoveEmpty() {
		testListInteger.remove(0);
	}

	@Test
	public void testRemoveOne()
	{
		testListInteger.append(42);
		testListInteger.remove(0);
		assertEquals("The list should be empty",true,testListInteger.isEmpty());
	}
	
	@Test
	public void testRemoveNotEmpty()
	{
		for(int i=0;i<10;i++)
			testListInteger.prepend(i);
		testListInteger.remove(5);
		assertEquals("The 5th element should be 6",3,testListInteger.get(5).intValue());
		assertEquals("There should be 9 elements",9,testListInteger.size());
	}
	
	//------------------------------------------------------------------------
	//|removeHead                                                            |
	//------------------------------------------------------------------------
	@Test(expected=NoSuchElementException.class)
	public void testRemoveHeadEmpty() {
		testListInteger.removeHead();
	}

	@Test
	public void testRemoveHeadOne()
	{
		testListInteger.prepend(42);
		testListInteger.removeHead();
		assertEquals("The list should be empty",true,testListInteger.isEmpty());
	}
	
	@Test
	public void testRemoveHeadNotEmpty()
	{
		for(int i=0;i<10;i++)
			testListInteger.prepend(i);
		testListInteger.removeHead();
		assertEquals("The first element should be 8",8,testListInteger.head().intValue());
		assertEquals("There should be 9 elements",9,testListInteger.size());
	}
	
	//------------------------------------------------------------------------
	//|removeLast                                                            |
	//------------------------------------------------------------------------
	@Test(expected=NoSuchElementException.class)
	public void testRemoveLastEmpty() {
		testListInteger.removeLast();
	}

	@Test
	public void testRemoveLastOne()
	{
		testListInteger.prepend(42);
		testListInteger.removeLast();
		assertEquals("The list should be empty",true,testListInteger.isEmpty());
	}
	
	@Test
	public void testRemoveLastNotEmpty()
	{
		for(int i=0;i<10;i++)
			testListInteger.prepend(i);
		testListInteger.removeLast();
		assertEquals("The last element should be 1",1,testListInteger.get(8).intValue());
		assertEquals("There should be 9 elements",9,testListInteger.size());
	}
	

	//------------------------------------------------------------------------
	//|contains                                                              |
	//------------------------------------------------------------------------		
	@Test
	public void testContainsEmpty() {
		assertEquals("Should be false because the list is empty",false,testListInteger.contains(42));
	}
	
	@Test
	public void testContainOneTrue(){
		testListInteger.prepend(42);
		assertEquals("Should be true, 42 is in fact in the list",true,testListInteger.contains(42));
	}
	
	@Test
	public void testContainOneFalse(){
		testListInteger.prepend(42);
		assertEquals("Should be false, 0 is not in the list", false,testListInteger.contains(0));
	}
	//------------------------------------------------------------------------
	//|Head                                                                  |
	//------------------------------------------------------------------------	
	
	@Test
	public void testHeadEmpty() {
		assertEquals("Should be null, the list is empty",null,testListInteger.head());
	}
	
	@Test
	public void testHeadOne(){
		testListInteger.prepend(42);
		assertEquals("Should be 42",42,testListInteger.head().intValue());
	}
	
	@Test
	public void testHeadMany(){
		for(int i=0;i<10;i++)
			testListInteger.append(i);
		assertEquals("Should be 0",0,testListInteger.head().intValue());
	}
	//------------------------------------------------------------------------
	//|tail                                                                  |
	//------------------------------------------------------------------------	

	@Test
	public void testTailEmpty() {
		assertEquals("Should be nul when empty",null,testListInteger.tail());
	}
	
	@Test
	public void testTailOne() {
		testListInteger.append(42);
		assertEquals("Should be nul when one element in the list",null,testListInteger.tail());
	}
	
	@Test
	public void testTailTwo() {
		testListInteger.append(42);
		testListInteger.append(55);
		l2.append(55);
		assertEquals("Should be true",true,testListInteger.tail().equals(l2));
	}
	
	@Test
	public void testTailMany() {
		for(int i=0;i<10;i++)
		{
			testListInteger.append(i);
			if(i>0)
				l2.append(i);
		}
		assertEquals("Should be true",true,testListInteger.tail().equals(l2));
	}
	
	//------------------------------------------------------------------------
	//|get                                                                   |
	//------------------------------------------------------------------------	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetEmpty() {
		testListInteger.get(0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetIndexBelowZero()
	{
		testListInteger.append(42);
		testListInteger.get(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetIndexBeyondSize()
	{
		testListInteger.append(42);
		testListInteger.append(55);
		testListInteger.get(150);
	}
	
	@Test
	public void testGetFirst()
	{
		testListInteger.append(42);
		testListInteger.append(55);
		assertEquals("Should be 42",42,testListInteger.get(0).intValue());
	}
	
	@Test
	public void testGetLast()
	{
		for(int i=0;i<10;i++)
			testListInteger.append(i);
		assertEquals("Should be 9",9,testListInteger.get(9).intValue());
	}
	
	@Test
	public void testGetInside()
	{
		for(int i=0;i<10;i++)
			testListInteger.append(i);
		assertEquals("Should be 5",5,testListInteger.get(5).intValue());
	}
	
	//------------------------------------------------------------------------
	//|set                                                                   |
	//------------------------------------------------------------------------	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetEmpty() {
		testListInteger.set(42, 0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetIndexBelowZero()
	{
		testListInteger.append(42);
		testListInteger.set(42,-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetIndexBeyondSize()
	{
		testListInteger.append(42);
		testListInteger.append(55);
		testListInteger.set(42,150);
	}

	@Test
	public void testSetOne() {
		testListInteger.append(42);
		assertEquals("Should be 42",42,testListInteger.set(55, 0).intValue());
		assertEquals("Should be 55",55,testListInteger.get(0).intValue());
	}
	
	@Test
	public void testSetMany() {
		for(int i=0;i<10;i++)
			testListInteger.append(i);
		assertEquals("Should be 5",5,testListInteger.set(42, 5).intValue());
		assertEquals("Should be 42",42,testListInteger.get(5).intValue());
	}
	
	/* 
	 * HERE STARTS THE TESTS FOR METHODS FROM LISTABS
	 */
	
	//------------------------------------------------------------------------
	//|isEmpty                                                               |
	//------------------------------------------------------------------------	
	@Test
	public void testIsEmptyEmpty() {
		assertEquals("Should be true when the list is empty",true,testListInteger.isEmpty());
	}
	
	@Test
	public void testIsEmptyOne() {
		testListInteger.append(42);
		assertEquals("Should be false when the list contains an element",false,testListInteger.isEmpty());
	}
	
	@Test
	public void testIsEmptyAppendRemove() {
		testListInteger.append(42);
		testListInteger.removeHead();
		assertEquals("Should be true",true,testListInteger.isEmpty());
	}
	
	//------------------------------------------------------------------------
	//|size                                                                  |
	//------------------------------------------------------------------------	
	@Test
	public void testSizeEmpty() {
		assertEquals("Should be 0 when the list is empty",0,testListInteger.size());
	}

	@Test
	public void testSizeMany() {
		for(int i=0;i<10;i++)
			testListInteger.append(i);
		assertEquals("Should be 10",10,testListInteger.size());
	}
	
	//------------------------------------------------------------------------
	//|getNthNode                                                            |
	//------------------------------------------------------------------------	
	//TODO
	@Ignore
	@Test
	public void testGetNthNode() {
		fail("Not yet implemented");
	}
	
	//------------------------------------------------------------------------
	//|equals                                                                |
	//------------------------------------------------------------------------	
	@Test
	public void testEqualsEmptyEmpty() {
		assertEquals("Should be true, both list are empty",true,testListInteger.equals(l2));
	}
	
	@Test
	public void testEqualsOneEmpty() {
		l2.append(42);
		assertEquals("Should be false, one list is empty, the other is not",false,testListInteger.equals(l2));
	}

	@Test
	public void testEqualsManyManySame() {
		for(int i=0;i<10;i++)
		{
			testListInteger.append(i);
			l2.append(i);
		}
		assertEquals("Should be true, both list contains the same elements",true,testListInteger.equals(l2));
	}
	
	@Test
	public void testEqualsManyManyDifferent() {
		for(int i=0;i<10;i++)
		{
			testListInteger.append(i);
			l2.prepend(i);
		}
		assertEquals("Should be false",false,testListInteger.equals(l2));
	}
	
}
