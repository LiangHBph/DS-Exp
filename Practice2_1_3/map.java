package Practice2_1_3;

import java.util.Scanner;

public class map {
	public static int[][] map;
	int m, n;
//���캯�����������ɶ�ά����ӳ���Թ�	
	public map(int m, int n) {
		this.m = m;
		this.n = n;
		map = new int[m + 2][n + 2];
//���ñ߿������Ԫ��Ϊ1
		for (int i = 0; i < m + 2; i++) {
			map[i][0] = map[i][n + 1] = 1;
		}
		for (int j = 1; j < n + 1; j++) {
			map[0][j] = map[m + 1][j] = 1;
		}
//�����Թ�
		Scanner sc = new Scanner(System.in);
		System.out.println("������" + m + "��" + n + "�е��Թ�ͼ��0��1�ֱ��ʾͨ·��·�ϣ���");
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
//Ѱ��ͨ·
	public LinkedStack search() throws Exception {
		int i = 1, j = 1;// i��
		map[i][j] = 2;
		LinkedStack L = new LinkedStack();
		while (i != m || j != n) {
			if (map[i][j + 1] == 0) {       // ��
				L.push(new StackElem(j, i, 1));
				map[i][j + 1] = 2;
				j += 1;
			} else if (map[i + 1][j] == 0) {// ��
				L.push(new StackElem(j, i, 2));
				map[i + 1][j] = 2;
				i += 1;
				
			} else if (map[i][j - 1] == 0) {// ��
				L.push(new StackElem(j, i, 3));
				map[i][j - 1] = 2;
				j -= 1;
				
			} else if (map[i - 1][j] == 0) {// ��
				L.push(new StackElem(j, i, 4));
				map[i - 1][j] = 2;
				i -= 1;
				
			} else {                       //��·����
				if (L.isEmpty()) {
					System.out.println("���Թ�û��ͨ·��");
				    break;
				}
				i = ((StackElem) L.peek()).y;
				j = ((StackElem) L.peek()).x;
				L.pop();
			}
			
		}
		L.push(new StackElem(j, i, 0));
		return L;
	}
}
