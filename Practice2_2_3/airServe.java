package Practice2_2_3;

import java.util.Scanner;
/*˵����
 * 1����ǰ�趨�����˺��࣬�������衢�������������Ϻ�����Ȼ�������Լ�����Ӻ��ߡ�
 *    ע��Ϊ���Է��㣬���������ؿ�������Ϊ10�ˡ�
 *    
 * 2����ϵͳ�ٶ�ÿ�˺������һ�ܷɻ�������չ����дplane�༰�ɻ����У����ҷɻ���ͬ�ȼ������տɻ����������ֵȼ�����λ�����ϲ�����
 * 
 * 3����ͼ����ʱ��Ϊ4��7����������������������ڲ�ѯ��
 * 
 * 4��a:��ѯ�����������
 *    b:��Ʊ���ܣ�������������������ԣ�
 *    c:�ٴζ�Ʊ���պö�����
 *    d:��Ʊ������Ҫ�����´ζ�Ʊ����������������ԣ������Զ�����ת�Ǽ��Ŷӹ��ܡ�
 *    e:��Ʊ��С���ϴζ�Ʊ��������С�ڽ���Ʊ��������
 *      �Ŷ����ˣ��˿̶�������Ʊ�����ڽ���Ʊ��Ʊ����ת������еĵڶ���
 *    f:��Ʊ
 *    g:��ѯ
*/     
public class airServe {

	public static void main(String[] args) {
		// ��������
		routeSqlist R = new routeSqlist();
		route route1 = new route("����", 001, 0000, 1, 100);
		route route2 = new route("����", 002, 0001, 3, 200);
		route route3 = new route("����", 003, 0002, 5, 10);// ������ڲ���
		route route4 = new route("�Ϻ�", 004, 0003, 7, 300);
		R.addRoute(route1, 0);
		R.addRoute(route2, 1);
		R.addRoute(route3, 2);
		R.addRoute(route4, 3);

		// a
		Scanner sc = new Scanner(System.in);
		System.out.print("�������ѯ�յ�վ�����ƣ�");
		String f = sc.next();
		R.checkRoute(f);
//b
		System.out.print("\n\n�����붩Ʊ����ż���Ʊ����");
		int x = R.checkThroughAirNum(sc.nextInt());
		int j = sc.nextInt();
		R.list[x].booking(j);
//c
		System.out.print("\n\n�����붩Ʊ����ż���Ʊ����");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//�Ŷ�d
		System.out.print("\n\n�����붩Ʊ����ż���Ʊ����");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//�Ŷ�e
		System.out.print("\n\n�����붩Ʊ����ż���Ʊ����");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//��Ʊf
		System.out.print("\n\n��������Ʊ����ż�Ԥ��������");
		x = R.checkThroughAirNum(sc.nextInt());
		f=sc.next();
		R.list[x].refund(f);
//��ѯg
		System.out.print("\n\n�������ѯ�յ�վ�����ƣ�");
		f = sc.next();
		R.checkRoute(f);
	}

}
