package main;

// http://en.wikipedia.org/wiki/List_of_data_structures


import tree.BinarySearchTree;
import list.CountSelfOrganizingList;
import list.LinkedList;
import list.MTFSelfOrganizingList;
import list.SelfOrganizingList;
import list.TransposeSelfOrganizingList;
import list.UnrolledLinkedList;

public class Main {

	public static void main(String[] args) {

		/*LinkedList<Integer> l2 = new LinkedList<Integer>();
		UnrolledLinkedList<Integer> l = new UnrolledLinkedList<Integer>();
		l.prepend(7);
		l2.prepend(7);
		l.prepend(2);
		l2.prepend(1);
		System.out.println(l.equals(l2));
		l.prepend(3);
		l.append(1);
		l.append(2);
		l.append(3);
		System.out.println(l);
		
		for(int i=0;i<100;i++)
		{
			l.prepend(i);
			l2.prepend(i);
		}
		System.out.println(l);
		System.out.println(l2);
		*/
		
		/*
		SelfOrganizingList<Integer> l = new MTFSelfOrganizingList<Integer>();
		for(int i=0;i<10;i++)
			l.append(i);
		System.out.println(l);
		for(int i=0;i<5;i++)
		{
			l.get(4);
			System.out.println(l);
		}
		*/
		
		/*
		BinarySearchTree<String> t = new BinarySearchTree<String>("toto");
		
		System.out.println("toto".compareTo("tott"));
	*/
		}

}
