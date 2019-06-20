package Practice4_1_3;

import java.util.Scanner;

public class Practice_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MGraph G = new MGraph(GraphKind.UDN, 14, 19, null, null);
		G.createUDN();
		ShortestPath_DIJ dij = new ShortestPath_DIJ();

		while (true) {
			System.out.print("请选择操作（0、查询景点     1、查询路径      2、退出）：");
			int i = sc.nextInt();
			int v1 = 0, v2 = 0;
			switch (i) {
			case 0:
				System.out.print("请输入查询景点名称：");
				String tar = sc.next();
				for (int j = 0; j < G.getVexNum(); j++) {
					if (((Sight) G.getVexs()[j]).name.equals(tar))
						((Sight) G.getVexs()[j]).searchInfor();
				}
				System.out.println("————————————————————————————————————————————————");
				break;

			case 1:
				System.out.print("请输入起止景点的名称：");
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
				System.out.print("最短路径为：");

				while ((int) dij.getP()[v2].peek() != v2)
					System.out.print(((Sight) G.getVexs()[(int) dij.getP()[v2].poll()]).name + "———>");

				System.out.print(((Sight) G.getVexs()[(int) dij.getP()[v2].poll()]).name);
				int length = dij.getD()[v2];
				System.out.print("\n路径长度为：" + length);
				System.out.println("\n————————————————————————————————————————————————");
				break;

			case 2:
				return;
			}
		}

	}

}
