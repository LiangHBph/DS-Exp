package Practice1_1_2;

import java.util.Scanner;

public class Sy1_2 {
	public static void main(String[] args) throws Exception {
		// ����˳���A
		Scanner sc = new Scanner(System.in);
		System.out.print("����������˳���A�ı�:");
		int n = sc.nextInt();
		SqList sqa = new SqList(n);
		System.out.println("�뽫" + n + "��Ԫ�ذ��յ������������A:");
		for (int i = 0; i < n; i++) {
			sqa.insert(i, sc.nextInt());
		}

		// ����˳���B
		System.out.print("����������˳���B�ı�:");
		n = sc.nextInt();
		SqList sqb = new SqList(n);
		System.out.println("�뽫" + n + "��Ԫ�ذ��յ������������B:");
		for (int i = 0; i < n; i++) {
			sqb.insert(i, sc.nextInt());
		}

		// ����˳���C
		System.out.print("����������˳���C�ı�:");
		n = sc.nextInt();
		SqList sqc = new SqList(n);
		System.out.println("�뽫" + n + "��Ԫ�ذ��յ������������C:");
		for (int i = 0; i < n; i++) {
			sqc.insert(i, sc.nextInt());
		}
		System.out.print("����˳���AΪ:");
		sqa.display();
		System.out.print("����˳���BΪ:");
		sqb.display();
		System.out.print("����˳���CΪ:");
		sqc.display();
		// �ҳ�B��C����ͬ��Ԫ�ز���A��ɾ��

		// ����ǰ�ᣬ˳�����Ԫ�ظ���
		int i = 0, j = 0, k = 0;
		while (i < sqa.length() && j < sqb.length() && k < sqc.length()) {

			while ((Integer) sqb.get(j) < (Integer) sqc.get(k)) {
				j++;
			}
			while ((Integer) sqb.get(j) > (Integer) sqc.get(k)) {
				k++;
			}
			if (sqa.indexOf(sqb.get(j)) != -1)
				sqa.remove(sqa.indexOf(sqb.get(j)));
			j++;
			k++;
		}
		System.out.print("ɾ������Ԫ�غ�����˳���AΪ:");
		sqa.display();
	}
}
