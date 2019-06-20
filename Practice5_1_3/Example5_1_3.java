package Practice5_1_3;

import java.util.Scanner;


public class Example5_1_3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Student st;
		RecordNode recordNode;
		SeqList sq = new SeqList(5);
		System.out.println("请依次输入学生学号、姓名、英语成绩和数学成绩（空格隔开）：");
		for (int i = 0; i < 5; i++) {
			st = new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());
			recordNode = new RecordNode(st.English + st.Math, st);
			sq.insert(i, recordNode);
		}
		sq.bubbleSort();
		System.out.println("采用冒泡排序进行排序：");
		RecordNode[] r = new RecordNode[5];
		r = sq.getRecord();
		for (int i = 4; i >= 0; i--) {
			st=(Student)r[i].getElement();
			st.display();
		}
	}

}
