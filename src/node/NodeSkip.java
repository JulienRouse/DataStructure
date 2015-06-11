package node;

import java.util.ArrayList;
import java.util.List;

import list.LinkedList;

//NEED AN IDEA TO MAKE IT WORK, WILL TRY AGAIN SOON
public class NodeSkip<T> implements Node<T>{
	
	public int maxLevel;
	NodeSkip<T> next[];
	int[] levelWidth;
	T val;
	
	public NodeSkip()
	{
		this.maxLevel = 16; //we take the assumption to store 2^16 elements in the skiplist
		this.next = new NodeSkip[16];
		this.levelWidth = new int[this.maxLevel];
	}

	
	
}
