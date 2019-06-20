package Practice2_2_3;

//已定票客户的链表
public class ClientLinkedList {
	bookedClient headb;
	bookedClient tearb;
	bookedClient temp;
	int length = 0;

	public ClientLinkedList() {
		headb = new bookedClient(null, 0);
		tearb=headb;
	}
    
	public void addClient(bookedClient a) {

		tearb.next=a;
		tearb=tearb.next;
		length++;
	}
    public void insert(bookedClient b,int i) {//i是座位号
    	temp=headb;
		while (temp.next.ticketNum!=i&&temp!=null) {
			temp=temp.next;
		}if (temp.next.ticketNum==i) {
			b.next=temp.next.next;
			temp.next=b;
		}
		
	}
	public void remove(String name) {
		bookedClient temp;
		temp = headb;
		while (temp.next!= null) {
			if (temp.next.name.equals(name)) {
				temp.next = temp.next.next;
				length--;
				
			}else temp.next = temp.next.next;
			
		}

	}

	public int length() {
		return length;
	}
}
