package Practice5_4_1;

import java.util.Scanner;

public class Practice5_4_1 {

	static HashTable T = null;

	public static void createHashtable() {
		T = new HashTable(20);
		Scanner sc = new Scanner(System.in);
		System.out.print("����������ҵĹؼ��ֵĸ�����");
		int n = sc.nextInt();
		System.out.print("��������ұ��еĹؼ������У�");
		for (int i = 0; i < n; i++) {
			T.hashInsert(sc.nextInt());
		}
	}

	public static void main(String[] args) {
        System.out.println("---������ϣ��---");
        createHashtable();
        System.out.println("�����Ĺ�ϣ��Ϊ��");
        T.HashDisplay();
        System.out.print("����������ҵĹؼ��֣�");
        Scanner sc = new Scanner(System.in);
        int key=sc.nextInt();
        RecordNode p=T.hashSearch(key);
        if ((p.getKey()).compareTo(key)==0) {
        	System.out.println("���ҳɹ���");
			
		} else {
			System.out.println("����ʧ�ܣ�");

		}
	}

}
