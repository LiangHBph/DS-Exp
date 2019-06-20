package Practice1_1_2;

import java.util.Scanner;

public class Sy1_2 {
	public static void main(String[] args) throws Exception {
		// 建立顺序表A
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入有序顺序表A的表长:");
		int n = sc.nextInt();
		SqList sqa = new SqList(n);
		System.out.println("请将" + n + "个元素按照递增依次输入表A:");
		for (int i = 0; i < n; i++) {
			sqa.insert(i, sc.nextInt());
		}

		// 建立顺序表B
		System.out.print("请输入有序顺序表B的表长:");
		n = sc.nextInt();
		SqList sqb = new SqList(n);
		System.out.println("请将" + n + "个元素按照递增依次输入表B:");
		for (int i = 0; i < n; i++) {
			sqb.insert(i, sc.nextInt());
		}

		// 建立顺序表C
		System.out.print("请输入有序顺序表C的表长:");
		n = sc.nextInt();
		SqList sqc = new SqList(n);
		System.out.println("请将" + n + "个元素按照递增依次输入表C:");
		for (int i = 0; i < n; i++) {
			sqc.insert(i, sc.nextInt());
		}
		System.out.print("有序顺序表A为:");
		sqa.display();
		System.out.print("有序顺序表B为:");
		sqb.display();
		System.out.print("有序顺序表C为:");
		sqc.display();
		// 找出B和C中相同的元素并在A中删除

		// 会有前提，顺序表中元素各异
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
		System.out.print("删除公有元素后有序顺序表A为:");
		sqa.display();
	}
}
