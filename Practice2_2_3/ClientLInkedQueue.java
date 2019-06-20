package Practice2_2_3;

//等候替补的客户队列
public class ClientLInkedQueue {
	waitClient headw;
	waitClient tearw;// 带头结点

	public ClientLInkedQueue() {
		headw = new waitClient(null, 0);
		tearw = headw;
	}

	public void offerWaitClient(waitClient peopleWait) {
		tearw.next = peopleWait;
		tearw = tearw.next;
	}
//选取队列中的符合空余票数的客户，并返回
	public waitClient pollSuitClient(int leftTicket) {// 传入空余票数
		waitClient temp;
		temp = headw;
		while (temp.next != null) {
			if (temp.next.ticketNum <= leftTicket) {
				waitClient p = temp.next;
				temp.next = temp.next.next;
				return p;
			} else
				temp = temp.next;
		}
		return null;

	}
}
