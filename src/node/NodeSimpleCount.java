package node;

public class NodeSimpleCount<T> extends NodeSimple<T> {

	public NodeSimpleCount<T> next;
	public int count;
	
	public NodeSimpleCount(T val) {
		super(val);
		this.count=0;
	}

	
}
