package Practice2_2_3;

//�Ⱥ��油�Ŀͻ�����
public class ClientLInkedQueue {
	waitClient headw;
	waitClient tearw;// ��ͷ���

	public ClientLInkedQueue() {
		headw = new waitClient(null, 0);
		tearw = headw;
	}

	public void offerWaitClient(waitClient peopleWait) {
		tearw.next = peopleWait;
		tearw = tearw.next;
	}
//ѡȡ�����еķ��Ͽ���Ʊ���Ŀͻ���������
	public waitClient pollSuitClient(int leftTicket) {// �������Ʊ��
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
