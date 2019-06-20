package Practice5_3_2;

import java.util.Scanner;

public class Practice5_3_2 extends BSTree {

	public static void main(String[] args) {

		BSTree bsTree = new Practice5_3_2();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入二叉排序树的结点个数：");
		int n = sc.nextInt();
		System.out.print("请输入结点的关键字序列：");
		for (int i = 0; i < n; i++) {
			bsTree.insertBST(sc.nextInt(), null);
		}

		System.out.println("\n创建的二叉排序树的中序遍历序列为：");
		bsTree.inOrderTraverse(bsTree.getRoot());
		System.out.println();
		System.out.print("\n请输入要删除结点的关键字：");
		n=sc.nextInt();
		bsTree.removeBST(n);
		System.out.println("\n删除后的二叉排序树的中序遍历序列为：");
		bsTree.inOrderTraverse(bsTree.getRoot());
	}
}
