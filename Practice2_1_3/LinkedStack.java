package Practice2_1_3;

import Example2_1.Node;

public class LinkedStack implements IStack {
    private Node top;
	@Override
	public void clear() {
		// TODO Auto-generated method stub
        top=null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		int length=0;
		Node pNode=top;
		while (pNode!=null) {
			pNode=pNode.next;
			length++;
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p=new Node(x, top);
		top=p;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		Node p=top;
		top=top.next;
		return p.data;
	}

}
