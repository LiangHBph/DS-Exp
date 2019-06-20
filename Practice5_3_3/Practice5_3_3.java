package Practice5_3_3;

import java.util.Scanner;

public class Practice5_3_3 extends BSTree {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Student st;
		int b;
		RecordNode recordNode;
		BSTree bsTree = new Practice5_3_3();
		System.out.println("请依次输入学生学号、姓名、英语成绩和数学成绩（空格隔开）：");
		for (int i = 0; i < 5; i++) {
			b = sc.nextInt();
			st = new Student(b, sc.next(), sc.nextInt(), sc.nextInt());

			bsTree.insertBST(b, st);
		}
		System.out.print("利用二叉排序树查找，请输入学生学号：");
		int a = sc.nextInt();
		Object t = bsTree.searchBST(a);
		st = (Student) (((RecordNode) t).getElement());
		st.display();

		System.out.print("请输入删除学生学号：");
		a = sc.nextInt();
		bsTree.removeBST(a);
		
		System.out.print("\n再次查找删除的学生，以验证确实删除,请输入查询学号：");
		a = sc.nextInt();

		bsTree.searchBST(a);
	}

}
/*
1001 王小红 88 98 
1002 李小平 78 67 
1003 赵一飞 87 86 
1004 张春江 67 56 
1005 吴占豪 88 78
 */