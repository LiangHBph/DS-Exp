package Practice1_1_3;

import java.util.Scanner;

public class student {
	// �������
	int number;
	int grades;
	String name;
	String gender;
	String address;
	String phoneNumber;
	// ���췽��
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
        "ѧ��:" + number + "  ����:" + name + "  �Ա�:" + gender +"  �ɼ�"+grades+ "  �绰:" + phoneNumber + "  ��ַ:" + address);
	}
}
