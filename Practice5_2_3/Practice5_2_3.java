package Practice5_2_3;

import java.util.Scanner;


public class Practice5_2_3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Student st;
		int b;
		RecordNode recordNode;
		SeqList sq = new SeqList(5);
		System.out.println("����������ѧ��ѧ�š�������Ӣ��ɼ�����ѧ�ɼ����ո��������");
		for (int i = 0; i < 5; i++) {
			b=sc.nextInt();
			st = new Student(b, sc.next(), sc.nextInt(), sc.nextInt());
			recordNode = new RecordNode(b, st);
			sq.insert(i, recordNode);
		}
		System.out.print("���ж��ֲ��ң�������ѧ��ѧ�ţ�");
		int a=sc.nextInt();
		b=sq.binarySearch(a);
	    RecordNode[] r=new RecordNode[5];
		r = sq.getRecord();
		st=(Student)r[b].getElement();
		st.display();
	}

}
/*
1001 ��С�� 88 98
1002 ��Сƽ 78 67
1003 ��һ�� 87 86
1004 �Ŵ��� 67 56
1005 ��ռ�� 88 78
*/