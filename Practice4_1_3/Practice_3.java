package Practice4_1_3;

import java.util.Scanner;

public class Practice_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MGraph G = new MGraph(GraphKind.UDN, 14, 19, null, null);
		G.createUDN();
		ShortestPath_DIJ dij = new ShortestPath_DIJ();

		while (true) {
			System.out.print("��ѡ�������0����ѯ����     1����ѯ·��      2���˳�����");
			int i = sc.nextInt();
			int v1 = 0, v2 = 0;
			switch (i) {
			case 0:
				System.out.print("�������ѯ�������ƣ�");
				String tar = sc.next();
				for (int j = 0; j < G.getVexNum(); j++) {
					if (((Sight) G.getVexs()[j]).name.equals(tar))
						((Sight) G.getVexs()[j]).searchInfor();
				}
				System.out.println("������������������������������������������������������������������������������������������������");
				break;

			case 1:
				System.out.print("��������ֹ��������ƣ�");
				String tar1 = sc.next();

				for (int j = 0; j < G.getVexNum(); j++) {
					if (((Sight) G.getVexs()[j]).name.equals(tar1))
						v1 = j;
				}
				tar1 = sc.next();
				for (int j = 0; j < G.getVexNum(); j++) {
					if (((Sight) G.getVexs()[j]).name.equals(tar1))
						v2 = j;
				}
				dij.DIJ(G, v1,v2);
				System.out.print("���·��Ϊ��");

				while ((int) dij.getP()[v2].peek() != v2)
					System.out.print(((Sight) G.getVexs()[(int) dij.getP()[v2].poll()]).name + "������>");

				System.out.print(((Sight) G.getVexs()[(int) dij.getP()[v2].poll()]).name);
				int length = dij.getD()[v2];
				System.out.print("\n·������Ϊ��" + length);
				System.out.println("\n������������������������������������������������������������������������������������������������");
				break;

			case 2:
				return;
			}
		}

	}

}
