package Practice5_3_2;

import java.util.Scanner;

public class Practice5_3_2 extends BSTree {

	public static void main(String[] args) {

		BSTree bsTree = new Practice5_3_2();
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
		System.out.print("\n������Ҫɾ�����Ĺؼ��֣�");
		n=sc.nextInt();
		bsTree.removeBST(n);
		System.out.println("\nɾ����Ķ����������������������Ϊ��");
		bsTree.inOrderTraverse(bsTree.getRoot());
	}
}
