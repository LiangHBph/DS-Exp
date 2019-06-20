package Practice3_1_3;

import java.util.Scanner;

public class Sy3_1_3 {
	// �������
	public static LinkStack postFind(BiTreeNode root, BiTreeNode q) {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ������ջ
			S.push(T); // ������ջ
			Boolean flag;// ���ʱ��
			BiTreeNode p = null;// pָ��ձ����ʵĽ��
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// ��ջ�������������ӽ����ջ
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // �ս����ջ
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// �鿴ջ��Ԫ��
					if (T.getRchild() == null || T.getRchild() == p) {
						if (q.getData() == T.getData()) {
							return S;
						} else {
							S.pop();// �Ƴ�ջ��Ԫ��
							p = T;// pָ��ձ����ʵĽ��
							flag = true;// ���÷��ʱ��
						} // ���ʽ��
					} else {
						S.push(T.getRchild());// �Һ��ӽ����ջ
						flag = false;// ����δ�����ʱ��
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
		System.out.print("������������ĺ�����к��и����У�");

		String postSt = sc.next();
		String inSt = sc.next();
		BiTree B = new BiTree(postSt, inSt, postSt.length()-1, postSt.length()-1, postSt.length());

		System.out.print("�����Ķ��������ȸ����к��и����У�������֤����");
		B.preRootTraverse();
		System.out.print(" ");
		B.inRootTraverse();
		System.out.println();
		
		System.out.print("��������ҽ��P��");
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
				System.out.print("������>");
			}
		}
	
	}
//ABDEGCFH DBGEAFHC
//DGEBHFCA DBGEAFHC
}
