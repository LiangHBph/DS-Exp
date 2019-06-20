package Practice5_2_2;

public class IndexNode {

	private int maxKey;
	private Node head;
	public IndexNode() {
		this.head=new Node(0);
		this.maxKey=0;
	}
	public final int getMaxKey() {
		return maxKey;
	}
	public final void setMaxKey(int maxKey) {
		this.maxKey = maxKey;
	}
	public final Node getHead() {
		return head;
	}
	public final void setHead(Node head) {
		this.head = head;
	}

}
