package Practice5_3_1;

import java.util.Scanner;

public class Practice5_3_1 extends BSTree {
	
	public static void main(String[] args) {
		BSTree bsTree = new Practice5_3_1();
		Scanner sc = new Scanner(System.in);
		System.out.print("����������������Ľ�������");
		int n = sc.nextInt();
		System.out.print("��������Ĺؼ������У�");
		for (int i = 0; i < n; i++) {
			bsTree.insertBST(sc.nextInt(), null);
		}

		System.out.println("\n�����Ķ����������������������Ϊ��");
		bsTree.inOrderTraverse(bsTree.getRoot());
		System.out.println();
	}

}
