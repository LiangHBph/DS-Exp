package Practice5_2_2;

import java.util.Scanner;



public class Practice5_2_2 {
    public static IndexList creatIndexList() {
		IndexList L=new IndexList();//Ĭ�ϸ���10�����
		int i=1;
		IndexNode IN;
		Scanner sc=new Scanner(System.in);
		while (i<4) {
			System.out.print("������"+i+"�ſ鵱�еĹؼ��֣�����-1��������");
			IN=new IndexNode();
			Node temp=IN.getHead();
			int a=sc.nextInt();
			while (a!=-1) {
				Node N1=new Node(a);
				temp.setNext(N1);
				temp=temp.getNext();
				a=sc.nextInt();
			}
			IN.setMaxKey(findMax(IN.getHead()));
			L.insert(IN, i);
			i++;
		}
		return L;
		
	}
    public static int findMax(Node node) {
    	int max=0;
    	while (node.getNext()!=null) {
			if (node.getNext().getKey()>max) {
				max=node.getNext().getKey();
			}
			node=node.getNext();
		}
    	return max;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�����ֿ���ұ�");
		IndexList L=creatIndexList();
		System.out.println();

		System.out.print("����������ҵĹؼ��֣�");
		int b=sc.nextInt();
		L.fenKuaiSearch(b);
		System.out.print("����������ҵĹؼ��֣�");
		b=sc.nextInt();
		L.fenKuaiSearch(b);
		
	}

}
/*
3 6 12 9 4 -1
15 23 14 21 13 -1
31 45 37 47 -1
*/