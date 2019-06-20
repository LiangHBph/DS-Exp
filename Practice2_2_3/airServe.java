package Practice2_2_3;

import java.util.Scanner;
/*说明：
 * 1、提前设定了四趟航班，飞往巴黎、北京、东京和上海。当然，还可以继续添加航线。
 *    注：为测试方便，东京航班载客量设置为10人。
 *    
 * 2、本系统假定每趟航班仅有一架飞机（需扩展可再写plane类及飞机队列），且飞机不同等级的座舱可互换（即各种等级的座位数量上不定）
 * 
 * 3、截图测试时间为4月7日周六（测试最近航班日期查询）
 * 
 * 4、a:查询东京航班情况
 *    b:订票功能（不订满，方便后续测试）
 *    c:再次订票（刚好订满）
 *    d:订票（客量要大于下次订票客量，方便后续测试），测试订满后转登记排队功能。
 *    e:订票（小于上次订票人数，且小于将退票的人数）
 *      排队两人，此刻队首需求票量大于将退票的票数，转向队列中的第二人
 *    f:退票
 *    g:查询
*/     
public class airServe {

	public static void main(String[] args) {
		// 构建航线
		routeSqlist R = new routeSqlist();
		route route1 = new route("巴黎", 001, 0000, 1, 100);
		route route2 = new route("北京", 002, 0001, 3, 200);
		route route3 = new route("东京", 003, 0002, 5, 10);// 方便后期测试
		route route4 = new route("上海", 004, 0003, 7, 300);
		R.addRoute(route1, 0);
		R.addRoute(route2, 1);
		R.addRoute(route3, 2);
		R.addRoute(route4, 3);

		// a
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入查询终点站的名称：");
		String f = sc.next();
		R.checkRoute(f);
//b
		System.out.print("\n\n请输入订票航班号及订票量：");
		int x = R.checkThroughAirNum(sc.nextInt());
		int j = sc.nextInt();
		R.list[x].booking(j);
//c
		System.out.print("\n\n请输入订票航班号及订票量：");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//排队d
		System.out.print("\n\n请输入订票航班号及订票量：");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//排队e
		System.out.print("\n\n请输入订票航班号及订票量：");
		x = R.checkThroughAirNum(sc.nextInt());
		j = sc.nextInt();
		R.list[x].booking(j);
		
//退票f
		System.out.print("\n\n请输入退票航班号及预留姓名：");
		x = R.checkThroughAirNum(sc.nextInt());
		f=sc.next();
		R.list[x].refund(f);
//查询g
		System.out.print("\n\n请输入查询终点站的名称：");
		f = sc.next();
		R.checkRoute(f);
	}

}
