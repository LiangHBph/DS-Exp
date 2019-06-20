package Practice5_2_3;

import java.util.Scanner;


public class Practice5_2_3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Student st;
		int b;
		RecordNode recordNode;
		SeqList sq = new SeqList(5);
		System.out.println("请依次输入学生学号、姓名、英语成绩和数学成绩（空格隔开）：");
		for (int i = 0; i < 5; i++) {
			b=sc.nextInt();
			st = new Student(b, sc.next(), sc.nextInt(), sc.nextInt());
			recordNode = new RecordNode(b, st);
			sq.insert(i, recordNode);
		}
		System.out.print("进行二分查找，请输入学生学号：");
		int a=sc.nextInt();
		b=sq.binarySearch(a);
	    RecordNode[] r=new RecordNode[5];
		r = sq.getRecord();
		st=(Student)r[b].getElement();
		st.display();
	}

}
/*
1001 王小红 88 98
1002 李小平 78 67
1003 赵一飞 87 86
1004 张春江 67 56
1005 吴占豪 88 78
*/