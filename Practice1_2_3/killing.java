package Practice1_2_3;
import java.util.Scanner;
public class killing {
	// ��Ա����
public static LinkList throwPeople(int n,int m,LinkList L) {//mΪ������
		// ���봬�ϵ������������Լ���ɱ�˴����������ж�������Ҫ�����ܶ��
		int k = 0;// ������
		int i = 0;
		Node p = L.getHead().getNext();
		while (i < n / 2) {// ÿɱһ����ѭ��һ��
			if (k % m == m-1) {
				System.out.println(p.getData()+"�����´���������"+k+"��");
				p.setData(p.getNext().getData());
				p.setNext(p.getNext().getNext());
				p = p.getNext();
				k += 2;
				i++;
			} else {
				p = p.getNext();
				k++;
			}
		}
		return L;

	}

public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("������ȫ��������");
		int n=sc.nextInt();
		System.out.print("�����뵹ù���");
		int m=sc.nextInt();
		LinkList lBoat = new LinkList(n, true);
		//���������Ϊѭ��
		Node p = lBoat.getHead();
		while (p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(lBoat.getHead().getNext());
		throwPeople(n,m,lBoat);
		System.out.println("�Ҵ������Ϊ��");
		p = lBoat.getHead().getNext();
		int q=n-n/2;
		while (q>0) {
			System.out.print(p.getData()+" ");
			p = p.getNext();
			q--;
		}
	}
 
}
