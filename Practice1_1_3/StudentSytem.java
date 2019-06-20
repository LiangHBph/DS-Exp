package Practice1_1_3;

import java.util.Scanner;

public class StudentSytem {

	public static void main(String[] args) {
		system stu = new system();
		System.out.print("请输入学生数量");
		Scanner sc = new Scanner(System.in);
		
		stu.build(sc.nextInt());// 检验建立功能，利用了插入
		for (int i = 0; i < stu.List.length/3; i++) {
			System.out.print("输入一名学生的学号、姓名、姓别、成绩、电话和地址:");
			student x = new student(sc);
			stu.insert(i, x);
		}
		// 输出
		stu.display();
		// 修改
		System.out.print("请输入要修改成绩的学生的学号及修改成绩：");
		stu.changeThroughNumber(sc.nextInt(), sc.nextInt());
		// 插入
		System.out.print("请输入要增加的学生的学号、姓名、姓别、成绩、电话和地址:");
		student x = new student(sc);
		stu.insert(stu.cur, x);
		//删除
		System.out.print("请输入要删除的学生的学号");
		stu.removeThroughNumber(sc.nextInt(), stu.List);
		stu.display();
	    //查询
	    System.out.print("请输入要查询的学生的学号");
	    stu.List[stu.getThroughNumber(stu.List, sc.nextInt())].display();
	    System.out.print("请输入要查询的学生的姓名");
	    stu.List[stu.getThroughName(stu.List, sc.next())].display();
	}
}
