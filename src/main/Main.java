package main;

// http://en.wikipedia.org/wiki/List_of_data_structures

import list.LinkedList;
import list.UnrolledLinkedList;

public class Main {

	public static void main(String[] args) {

		UnrolledLinkedList<Integer> l2 = new UnrolledLinkedList<Integer>();
		UnrolledLinkedList<Integer> l = new UnrolledLinkedList<Integer>();
	/*	l.prepend(7);
		l2.prepend(7);
		l.prepend(2);
		l2.prepend(1);
		System.out.println(l.equals(l2));
		l.prepend(3);
		l.append(1);
		l.append(2);
		l.append(3);
		System.out.println(l);
		*/
		for(int i=0;i<100;i++)
			l.prepend(i);
		System.out.println(l);
		
	}

}
