package Practice2_2_3;
import java.util.Calendar;

public class routeSqlist {
	route[] list;
	int length=0;

	public routeSqlist() {
		list = new route[100];// ���100������
	}

	public void addRoute(route r, int i) {
		list[i] = r;
		length++;
	}


	public void checkRoute(String finalStation) {
		for (int j = 0; j <length; j++) {
			if (list[j].finalStation.equals(finalStation)) {
				System.out.print("����ţ�"+list[j].airNum + "     �ɻ��ţ�" + list[j].planeNum + "     ����" + list[j].weekNum + "     ");
				int m=list[j].getdate().get(Calendar.MONTH);
				int d=list[j].getdate().get(Calendar.DAY_OF_MONTH);
				System.out.print("����������ڣ�"+m+"��"+d+"��");
				System.out.print("     ��Ʊ����"+list[j].getLeft());
			}
		}
	}
	public int checkThroughAirNum(int airNum) {
		for (int j = 0; j <length; j++) {
			if (list[j].airNum==airNum) {
			return j;
			}
		}
		System.out.println("�޴˺��࣡����");
		return -1;
	}

}
