package Practice2_1_3;

import java.util.Scanner;

public class map {
	public static int[][] map;
	int m, n;
//构造函数，用以生成二维数组映射迷宫	
	public map(int m, int n) {
		this.m = m;
		this.n = n;
		map = new int[m + 2][n + 2];
//设置边框的所有元素为1
		for (int i = 0; i < m + 2; i++) {
			map[i][0] = map[i][n + 1] = 1;
		}
		for (int j = 1; j < n + 1; j++) {
			map[0][j] = map[m + 1][j] = 1;
		}
//构造迷宫
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入" + m + "行" + n + "列的迷宫图（0和1分别表示通路和路障）：");
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
//寻找通路
	public LinkedStack search() throws Exception {
		int i = 1, j = 1;// i行
		map[i][j] = 2;
		LinkedStack L = new LinkedStack();
		while (i != m || j != n) {
			if (map[i][j + 1] == 0) {       // 东
				L.push(new StackElem(j, i, 1));
				map[i][j + 1] = 2;
				j += 1;
			} else if (map[i + 1][j] == 0) {// 南
				L.push(new StackElem(j, i, 2));
				map[i + 1][j] = 2;
				i += 1;
				
			} else if (map[i][j - 1] == 0) {// 西
				L.push(new StackElem(j, i, 3));
				map[i][j - 1] = 2;
				j -= 1;
				
			} else if (map[i - 1][j] == 0) {// 北
				L.push(new StackElem(j, i, 4));
				map[i - 1][j] = 2;
				i -= 1;
				
			} else {                       //无路可走
				if (L.isEmpty()) {
					System.out.println("该迷宫没有通路。");
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
