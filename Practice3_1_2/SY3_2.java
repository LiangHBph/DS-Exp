package Practice3_1_2;

import java.util.Scanner;

import Stacks.SqStack;

public class SY3_2 {
	//�ǵݹ�
    private static void exChang1(BiTreeNode T)throws Exception {
    	System.out.println("���÷ǵݹ鷽�����侵����");
		SqStack s=new SqStack(100);
		if (T!=null) {
			s.push(T);
			do {
				T=(BiTreeNode)s.pop();
				if (T.getLchild()!=null||T.getRchild()!=null) {
					BiTreeNode p=(BiTreeNode)T.getLchild();
					T.setLchild(T.getRchild());
					T.setRchild(p);
				}
				if (T.getLchild()!=null) {
					s.push(T.getLchild());
				}
				if (T.getRchild()!=null) {
					s.push(T.getRchild());
				}
			} while (!s.isEmpty());
		}
	}
    //�ݹ�
    private static void exchang2(BiTreeNode T) {
    	
		if (T!=null) {
			if (T.getLchild()!=null||T.getRchild()!=null) {
				BiTreeNode p=(BiTreeNode)T.getLchild();
				T.setLchild(T.getRchild());
				T.setRchild(p);
			}
			exchang2(T.getLchild());
			exchang2(T.getRchild());
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
  System.out.print("��������������ȸ����к��и����У�");
  
  String preSt=sc.next();
  String inSt=sc.next();
  BiTree B=new BiTree(preSt, inSt, 0,0,inSt.length());
  B.postRootTraverse();
  System.out.print("�����Ķ��������ȸ����к��и����У�������֤����");
  B.preRootTraverse();
  System.out.print(" ");
  B.inRootTraverse();
  System.out.println();
  
  
  exChang1(B.getRoot());
  System.out.println("��ʱ���������ȸ����м��������Ϊ��");
  B.preRootTraverse();
  System.out.print(" ");
  B.inRootTraverse();
  System.out.println();
  
  System.out.println("���õݹ鷽�����侵����");
  exchang2(B.getRoot());
  System.out.println("��ʱ���������ȸ����м��������Ϊ��");
  B.preRootTraverse();
  System.out.print(" ");
  B.inRootTraverse();
  System.out.println();
  
		
	}

}
