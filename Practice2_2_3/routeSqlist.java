package Practice2_2_3;
import java.util.Calendar;

public class routeSqlist {
	route[] list;
	int length=0;

	public routeSqlist() {
		list = new route[100];// 最多100条航线
	}

	public void addRoute(route r, int i) {
		list[i] = r;
		length++;
	}


	public void checkRoute(String finalStation) {
		for (int j = 0; j <length; j++) {
			if (list[j].finalStation.equals(finalStation)) {
				System.out.print("航班号："+list[j].airNum + "     飞机号：" + list[j].planeNum + "     星期" + list[j].weekNum + "     ");
				int m=list[j].getdate().get(Calendar.MONTH);
				int d=list[j].getdate().get(Calendar.DAY_OF_MONTH);
				System.out.print("最近航班日期："+m+"月"+d+"日");
				System.out.print("     余票数："+list[j].getLeft());
			}
		}
	}
	public int checkThroughAirNum(int airNum) {
		for (int j = 0; j <length; j++) {
			if (list[j].airNum==airNum) {
			return j;
			}
		}
		System.out.println("无此航班！！！");
		return -1;
	}

}
