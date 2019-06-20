package Practice5_2_2;

public class Node {

	private int key;
	private Node next;
	public Node(int key) {
		this.key=key;
	}
	
	public final int getKey() {
		return key;
	}
	public final void setKey(int key) {
		this.key = key;
	}
	public final Node getNext() {
		return next;
	}
	public final void setNext(Node next) {
		this.next = next;
	}
	
}
