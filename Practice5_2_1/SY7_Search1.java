package Practice5_2_1;

import java.util.Scanner;

public class SY7_Search1 {
	static SeqList ST=null;
    public static void createSearchList() throws Exception {
        ST=new SeqList(20);
        Scanner sc=new Scanner(System.in);
        System.out.print("��������ұ�ı���");
        int n=sc.nextInt();
        KeyType[] k=new KeyType[n];
        System.out.print("��������ұ��еĹؼ������У�");
        for (int i = 0; i < n; i++) {
			k[i]=new KeyType(sc.nextInt());
		}
        for (int i = 0; i < n; i++) {
			RecordNode r=new RecordNode(k[i]);
			ST.insert(i, r);
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		KeyType key1,key2;
		boolean flag=true;
		while (flag) {
			System.out.println("1--˳�����         2--���ֲ���        3--�˳�");
			System.out.print("������ѡ��1-3����");
			int i=sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("����˳����ұ�");
				createSearchList();
				System.out.print("���������������ҵĹؼ��֣�");
				key1=new KeyType(sc.nextInt());
				key2=new KeyType(sc.nextInt());
				System.out.println("seqSearch("+key1.getKey()+")="+ST.seqSearch(key1));
				System.out.println("seqSearch("+key1.getKey()+")="+ST.seqSearch(key2));
				break;
			case 2:
				System.out.println("����˳����ұ�");
				createSearchList();
				System.out.print("���������������ҵĹؼ��֣�");
				key1=new KeyType(sc.nextInt());
				key2=new KeyType(sc.nextInt());
				System.out.println("seqSearch("+key1.getKey()+")="+ST.binarySearch(key1));
				System.out.println("seqSearch("+key1.getKey()+")="+ST.binarySearch(key2));
				break;
            case 3:
            	flag=false;
            	break;
			}
			
		}

		
	}

}
