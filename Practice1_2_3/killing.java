package Practice1_2_3;
import java.util.Scanner;
public class killing {
	// 成员方法
public static LinkList throwPeople(int n,int m,LinkList L) {//m为所报号
		// 传入船上的总人数，用以计算杀人次数，否则判断条件需要遍历很多次
		int k = 0;// 计数器
		int i = 0;
		Node p = L.getHead().getNext();
		while (i < n / 2) {// 每杀一个人循环一次
			if (k % m == m-1) {
				System.out.println(p.getData()+"被扔下船！遍历了"+k+"次");
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
		System.out.print("请输入全部人数：");
		int n=sc.nextInt();
		System.out.print("请输入倒霉序号");
		int m=sc.nextInt();
		LinkList lBoat = new LinkList(n, true);
		//将单链表改为循环
		Node p = lBoat.getHead();
		while (p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(lBoat.getHead().getNext());
		throwPeople(n,m,lBoat);
		System.out.println("幸存者序号为：");
		p = lBoat.getHead().getNext();
		int q=n-n/2;
		while (q>0) {
			System.out.print(p.getData()+" ");
			p = p.getNext();
			q--;
		}
	}
 
}
