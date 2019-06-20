package Practice5_3_3;

import java.util.Scanner;

public class Practice5_3_3 extends BSTree {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Student st;
		int b;
		RecordNode recordNode;
		BSTree bsTree = new Practice5_3_3();
		System.out.println("����������ѧ��ѧ�š�������Ӣ��ɼ�����ѧ�ɼ����ո��������");
		for (int i = 0; i < 5; i++) {
			b = sc.nextInt();
			st = new Student(b, sc.next(), sc.nextInt(), sc.nextInt());

			bsTree.insertBST(b, st);
		}
		System.out.print("���ö������������ң�������ѧ��ѧ�ţ�");
		int a = sc.nextInt();
		Object t = bsTree.searchBST(a);
		st = (Student) (((RecordNode) t).getElement());
		st.display();

		System.out.print("������ɾ��ѧ��ѧ�ţ�");
		a = sc.nextInt();
		bsTree.removeBST(a);
		
		System.out.print("\n�ٴβ���ɾ����ѧ��������֤ȷʵɾ��,�������ѯѧ�ţ�");
		a = sc.nextInt();

		bsTree.searchBST(a);
	}

}
/*
1001 ��С�� 88 98 
1002 ��Сƽ 78 67 
1003 ��һ�� 87 86 
1004 �Ŵ��� 67 56 
1005 ��ռ�� 88 78
 */