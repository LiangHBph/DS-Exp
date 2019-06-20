package Practice4_1_3;

import java.util.Scanner;

//ͼ�������ʾ��
public class MGraph implements IGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;// ͼ�������־

	private int vexNum, arcNum;// ͼ�ĵ�ǰ�������ͱ���

	private Object[] vexs;// ����

	public int[][] arcs;// �ڽӾ���

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

	// ����һ��ͼ
	public void createGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ͼ�����ͣ�");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch (kind) {
		case UDN:
			createUDN();// ����������
			return;
		}
	}

	// ����������
	public void createUDN() {
		vexs = new Object[vexNum];
		vexs[0] = new Sight("��У��", "��У�ż��");
		vexs[1] = new Sight("��У��", "��У�ż��");
		vexs[2] = new Sight("��У��", "��У�ż��");
		vexs[3] = new Sight("��У��", "��У�ż��");
		vexs[4] = new Sight("ʳ��", "��ʳ�ÿ�����500��ͬʱ�Ͳͣ���ʦ������Ҫ������");
		vexs[5] = new Sight("�������г�ʵ����", "�������г�ʵ���Ҽ��");
		vexs[6] = new Sight("ӣ�����", "ӣ��������");
		vexs[7] = new Sight("ͼ���", "ʼ����1976�꣬1993�����Ϊ������ѧ�ػʵ���Уͼ���");
		vexs[8] = new Sight("������", "���������");
		vexs[9] = new Sight("������", "�����ݼ��");
		vexs[10] = new Sight("��Ӿ��", "��Ӿ�ݼ��");
		vexs[11] = new Sight("����", "���ü��");
		vexs[12] = new Sight("��ѧ¥", "��ѧ¥���");
		vexs[13] = new Sight("����", "������");
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

	// ���ض�����
	public int getVexNum() {
		return vexNum;
	}

	// ���ر���
	public int getArcNum() {
		return arcNum;
	}

	// ���������ֵvex����������ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// ����v��ʾ����ֵ�� 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		return vexs[v];
	}

	// ����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1�� 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0��v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");

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
