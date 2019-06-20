package Practice4_1_3;

import java.util.Scanner;

//图的数组表示法
public class MGraph implements IGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;// 图的种类标志

	private int vexNum, arcNum;// 图的当前顶点数和边数

	private Object[] vexs;// 顶点

	public int[][] arcs;// 邻接矩阵

	public MGraph() {
		this(null, 0, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	// 创建一个图
	public void createGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的类型：");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch (kind) {
		case UDN:
			createUDN();// 构造无向网
			return;
		}
	}

	// 创建无向网
	public void createUDN() {
		vexs = new Object[vexNum];
		vexs[0] = new Sight("正校门", "正校门简介");
		vexs[1] = new Sight("东校门", "东校门简介");
		vexs[2] = new Sight("西校门", "西校门简介");
		vexs[3] = new Sight("北校门", "北校门简介");
		vexs[4] = new Sight("食堂", "本食堂可容纳500人同时就餐，是师生的主要餐饮区");
		vexs[5] = new Sight("磁悬浮列车实验室", "磁悬浮列车实验室简介");
		vexs[6] = new Sight("樱花大道", "樱花大道简介");
		vexs[7] = new Sight("图书馆", "始建于1976年，1993年更名为东北大学秦皇岛分校图书馆");
		vexs[8] = new Sight("体育场", "体育场简介");
		vexs[9] = new Sight("体育馆", "体育馆简介");
		vexs[10] = new Sight("游泳馆", "游泳馆简介");
		vexs[11] = new Sight("礼堂", "礼堂简介");
		vexs[12] = new Sight("教学楼", "教学楼简介");
		vexs[13] = new Sight("宿舍", "宿舍简介");
		arcs = new int[14][14];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		arcs[0][4] = arcs[4][0] = 35;
		arcs[0][11] = arcs[11][0] = 5;
		arcs[1][10] = arcs[10][1] = 75;
		arcs[1][13] = arcs[13][1] = 10;
		arcs[2][4] = arcs[4][2] = 30;
		arcs[2][7] = arcs[7][2] = 5;
		arcs[3][6] = arcs[6][3] = 15;
		arcs[3][7] = arcs[7][3] = 50;
		arcs[3][9] = arcs[9][3] = 15;
		arcs[3][10] = arcs[10][3] = 20;
		arcs[4][8] = arcs[8][4] = 60;
		arcs[4][11] = arcs[11][4] = 40;
		arcs[5][8] = arcs[8][5] = 45;
		arcs[5][11] = arcs[11][5] = 10;
		arcs[8][11] = arcs[11][8] = 50;
		arcs[9][10] = arcs[10][9] = 20;
		arcs[9][13] = arcs[13][9] = 100;
		arcs[11][12] = arcs[12][11] = 25;
		arcs[12][13] = arcs[13][12] = 20;
	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返回边数
	public int getArcNum() {
		return arcNum;
	}

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// 返回v表示结点的值， 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v];
	}

	// 返回v的第一个邻接点，若v没有邻接点则返回-1， 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public GraphKind getKind() {
		return kind;
	}

	public void setArcNum(int arcNum) {
		this.arcNum = arcNum;
	}

	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
	}

	public void setKind(GraphKind kind) {
		this.kind = kind;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public void setVexs(Object[] vexs) {
		this.vexs = vexs;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public Object[] getVexs() {
		return vexs;
	}

}
