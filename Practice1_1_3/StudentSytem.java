package Practice1_1_3;

import java.util.Scanner;

public class StudentSytem {

	public static void main(String[] args) {
		system stu = new system();
		System.out.print("������ѧ������");
		Scanner sc = new Scanner(System.in);
		
		stu.build(sc.nextInt());// ���齨�����ܣ������˲���
		for (int i = 0; i < stu.List.length/3; i++) {
			System.out.print("����һ��ѧ����ѧ�š��������ձ𡢳ɼ����绰�͵�ַ:");
			student x = new student(sc);
			stu.insert(i, x);
		}
		// ���
		stu.display();
		// �޸�
		System.out.print("������Ҫ�޸ĳɼ���ѧ����ѧ�ż��޸ĳɼ���");
		stu.changeThroughNumber(sc.nextInt(), sc.nextInt());
		// ����
		System.out.print("������Ҫ���ӵ�ѧ����ѧ�š��������ձ𡢳ɼ����绰�͵�ַ:");
		student x = new student(sc);
		stu.insert(stu.cur, x);
		//ɾ��
		System.out.print("������Ҫɾ����ѧ����ѧ��");
		stu.removeThroughNumber(sc.nextInt(), stu.List);
		stu.display();
	    //��ѯ
	    System.out.print("������Ҫ��ѯ��ѧ����ѧ��");
	    stu.List[stu.getThroughNumber(stu.List, sc.nextInt())].display();
	    System.out.print("������Ҫ��ѯ��ѧ��������");
	    stu.List[stu.getThroughName(stu.List, sc.next())].display();
	}
}
