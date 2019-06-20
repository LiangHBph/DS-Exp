package Practice2_2_3;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Hanoi.state;
import Practice1_1_3.system;

public class route {// ÿ�˺������ҽ���һ�ܷɻ�
	// ����˸�����
	String finalStation;// Ŀ�ĵ�
	int airNum;// �����
	int planeNum;// �ɻ��ͺ�
	int weekNum;// �����ܼ�

	int maxClientNum;// ��������
	int leftClientNum;// ������

	ClientLinkedList booked;
	ClientLInkedQueue wait;

	// ���췽��
	public route(String finalStation, int airNum, int planeNum, int weekNum, int maxClientNum) {
		this.finalStation = finalStation;
		this.airNum = airNum;
		this.planeNum = planeNum;
		this.weekNum = weekNum;
		this.maxClientNum = maxClientNum;
		booked = new ClientLinkedList();
		wait = new ClientLInkedQueue();
	}

	public Calendar getdate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int days = (weekNum - weekday + 7) % 7;
		calendar.set(year, month, day + days);
		return calendar;
	}

	public int getLeft() {
		return leftClientNum = maxClientNum - booked.length;
	}

	public void booking(int clientNum) {// ���費ͬ�ȼ��Ĳ�λ�ɻ�
		Scanner sc = new Scanner(System.in);
		if (booked.length + clientNum <= maxClientNum) {
			bookedClient temp;
			String name;
			int grade;
			System.out.print("������˿���������λ�ȼ���1��2��3����");
			name = sc.next();// ÿ�ζ��ö�Ʊ���������ȼ�¼��
			grade = sc.nextInt();
			System.out.print("��λ��Ϊ��������λ��ֵ��Ϊ׼����");// �����뿼�ǲ�λ�ȼ�����ʱ����λ�Ÿ�����һ�ֶ�Ʊ���
			for (int i = 0; i < clientNum; i++) {
				temp = new bookedClient(name, booked.length + 1);
				temp.setGrade(grade);
				booked.addClient(temp);
				System.out.print(booked.length + " ");
			}
		} else {
			System.out.print("��λ��������ѡ���Ƿ�Ǽ��ŶӺ�(�����ն�����)��");
			if (sc.next().equals("��")) {
				waitClient temp;
				System.out.print("������������");
				String name = sc.next();
				temp = new waitClient(name, clientNum);
				wait.offerWaitClient(temp);
				System.out.print("�Ѽ���ȴ����У�");
			}
		}
	}

	public void refund(String name) {// ��Ʊ�˿�
		bookedClient p = booked.headb;

		while (p != null) {
			if (p.next.name.equals(name)) {
				booked.remove(name);
				
				break;
			} else {
				p = p.next;
			}
		}
		System.out.println("��Ʊ�ɹ�����ӭ�ٴ�ʹ�á�");
		waitClient w = wait.pollSuitClient(maxClientNum - booked.length);
			System.out.print("�ѳɹ�Ϊ"+w.name+"��Ʊ������λ��Ϊ��������λ��ֵ��Ϊ׼����");// �����뿼�ǲ�λ�ȼ�����ʱ����λ�Ÿ�����һ�ֶ�Ʊ���
			for (int i = 0; i < w.ticketNum; i++) {
				p = new bookedClient(w.name, booked.length + 1);
				p.setGrade(2);
				booked.addClient(p);
				System.out.print(booked.length + " ");
		}
	}

}
