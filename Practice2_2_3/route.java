package Practice2_2_3;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Hanoi.state;
import Practice1_1_3.system;

public class route {// 每趟航班有且仅有一架飞机
	// 定义八个变量
	String finalStation;// 目的地
	int airNum;// 航班号
	int planeNum;// 飞机型号
	int weekNum;// 飞行周几

	int maxClientNum;// 最大客容量
	int leftClientNum;// 空座量

	ClientLinkedList booked;
	ClientLInkedQueue wait;

	// 构造方法
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

	public void booking(int clientNum) {// 假设不同等级的舱位可换
		Scanner sc = new Scanner(System.in);
		if (booked.length + clientNum <= maxClientNum) {
			bookedClient temp;
			String name;
			int grade;
			System.out.print("请输入乘客姓名、舱位等级（1、2或3）：");
			name = sc.next();// 每次都拿订票人姓名及等级录入
			grade = sc.nextInt();
			System.out.print("座位号为（最终座位以值机为准）：");// 否则须考虑舱位等级，此时的座位号更多是一种订票序号
			for (int i = 0; i < clientNum; i++) {
				temp = new bookedClient(name, booked.length + 1);
				temp.setGrade(grade);
				booked.addClient(temp);
				System.out.print(booked.length + " ");
			}
		} else {
			System.out.print("舱位已满，请选择是否登记排队候补(均按照二等座)：");
			if (sc.next().equals("是")) {
				waitClient temp;
				System.out.print("请输入姓名：");
				String name = sc.next();
				temp = new waitClient(name, clientNum);
				wait.offerWaitClient(temp);
				System.out.print("已加入等待队列！");
			}
		}
	}

	public void refund(String name) {// 退票退款
		bookedClient p = booked.headb;

		while (p != null) {
			if (p.next.name.equals(name)) {
				booked.remove(name);
				
				break;
			} else {
				p = p.next;
			}
		}
		System.out.println("退票成功！欢迎再次使用。");
		waitClient w = wait.pollSuitClient(maxClientNum - booked.length);
			System.out.print("已成功为"+w.name+"订票，其座位号为（最终座位以值机为准）：");// 否则须考虑舱位等级，此时的座位号更多是一种订票序号
			for (int i = 0; i < w.ticketNum; i++) {
				p = new bookedClient(w.name, booked.length + 1);
				p.setGrade(2);
				booked.addClient(p);
				System.out.print(booked.length + " ");
		}
	}

}
