package Practice4_1_2;

import java.util.Scanner;

//ͼ�������ʾ��
public class MGraph implements IGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;// ͼ�������־

	private int vexNum, arcNum;// ͼ�ĵ�ǰ�������ͱ���

	private Object[] vexs;// ����

	private int[][] arcs;// �ڽӾ���

	public MGraph() {
		this(null, 0, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs,
			int[][] arcs) {
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
		case UDG:
			createUDG();// ��������ͼ
			return;
		case DG:
			createDG();// ��������ͼ
			return;
		case UDN:
			createUDN();// ����������
			return;
		case DN:
			createDN();// ����������
			return;
		}
	}

	// ��������ͼ
	private void createUDG() {
		// ��
	};

	// ��������ͼ
	private void createDG() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���:");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������:");
		for (int v = 0; v < vexNum; v++)
			// ���춥������
			vexs[v] = sc.next();

		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = 0;

		System.out.println("����������ߵ���������:");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] =1;
		}
	};

	// ����������
	private void createUDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���:");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������:");
		for (int v = 0; v < vexNum; v++)
			// ���춥������
			vexs[v] = sc.next();

		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;

		System.out.println("����������ߵĶ��㼰��Ȩֵ:");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = sc.nextInt();
		}
	}

	// ����������
	private void createDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���:");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������:");
		for (int v = 0; v < vexNum; v++)
			// ���춥������
			vexs[v] = sc.next();

		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			// ��ʼ���ڽӾ���
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;

		System.out.println("��������ߵĶ��㼰��Ȩֵ:");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = sc.nextInt();
		}

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
