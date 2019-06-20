package Practice3_1_3;

import java.util.Scanner;

public class Sy3_1_3 {
	// 后根遍历
	public static LinkStack postFind(BiTreeNode root, BiTreeNode q) {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// 构造链栈
			S.push(T); // 根结点进栈
			Boolean flag;// 访问标记
			BiTreeNode p = null;// p指向刚被访问的结点
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // 空结点退栈
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// 查看栈顶元素
					if (T.getRchild() == null || T.getRchild() == p) {
						if (q.getData() == T.getData()) {
							return S;
						} else {
							S.pop();// 移除栈顶元素
							p = T;// p指向刚被访问的结点
							flag = true;// 设置访问标记
						} // 访问结点
					} else {
						S.push(T.getRchild());// 右孩子结点入栈
						flag = false;// 设置未被访问标记
					}
					if (!flag)
						break;
				}
			}
			return null;
		}
		return null;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入二叉树的后根序列和中根序列：");

		String postSt = sc.next();
		String inSt = sc.next();
		BiTree B = new BiTree(postSt, inSt, postSt.length()-1, postSt.length()-1, postSt.length());

		System.out.print("建立的二叉树的先根序列和中根序列（用以验证）：");
		B.preRootTraverse();
		System.out.print(" ");
		B.inRootTraverse();
		System.out.println();
		
		System.out.print("请输入查找结点P：");
		char p=sc.next().charAt(0);
		BiTreeNode pT=new BiTreeNode(p);
		LinkStack S=postFind(B.getRoot(), pT);
		LinkStack S1=new LinkStack();
		while (!S.isEmpty()) {
			S1.push(S.pop());
		}
		while (!S1.isEmpty()) {
			System.out.print(((BiTreeNode)S1.pop()).getData());
			if (S1.isEmpty()) {
				break;
			}else {
				System.out.print("———>");
			}
		}
	
	}
//ABDEGCFH DBGEAFHC
//DGEBHFCA DBGEAFHC
}
