package Practice1_1_3;

import java.util.Scanner;

public class student {
	// 定义变量
	int number;
	int grades;
	String name;
	String gender;
	String address;
	String phoneNumber;
	// 构造方法
	public student(Scanner sc) {
		// TODO Auto-generated constructor stub
		this.number =sc.nextInt();
		this.name = sc.next();
		this.gender =sc.next();
		this.grades=sc.nextInt();
		this.phoneNumber = sc.next();
		this.address = sc.next();
	}
	public void display() {
		System.out.println(
        "学号:" + number + "  姓名:" + name + "  性别:" + gender +"  成绩"+grades+ "  电话:" + phoneNumber + "  地址:" + address);
	}
}
