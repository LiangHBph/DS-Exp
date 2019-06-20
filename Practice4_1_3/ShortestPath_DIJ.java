package Practice4_1_3;

public class ShortestPath_DIJ {
	private LinkQueue[] P;// p�Ϲ���

	private int[] D;// v0�����ඥ��Ĵ�Ȩ����

	public final static int INFINITY = Integer.MAX_VALUE;

	// ��Dijkstra�㷨��������G��v0���㵽���ඥ��v�����·��P[v]����ȨֵD[v]

	LinkQueue temp = new LinkQueue();

	public void DIJ(MGraph G, int v0, int v2) {
		int vexNum = G.getVexNum();
		P = new LinkQueue[vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]Ϊtrue���ҽ���v����S,���Ѿ���ô�v0��v�����·��
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			P[v] = new LinkQueue();
			P[v].offer(v0);
			if (D[v] < INFINITY) {
				P[v].offer(v);
			}
		}

		D[v0] = 0;// ��ʼ����v0��������S��
		finish[v0] = true;

		int v = -1;

		// ��ʼ��ѭ����ÿ�����v0��ĳ��v��������·��������v��S��
		for (int i = 1; i < vexNum; i++) {// ����G.getVexNum-1������
			int min = INFINITY;// ��ǰ��֪��v0������������
			for (int w = 0; w < vexNum; w++)
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			finish[v] = true;// ��v0���������v����S��

			if (v == v2)
				return;

			for (int w = 0; w < vexNum; w++)
				// ���µ�ǰ���·��������
				if (!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w] < D[w])) { // �޸�D[w]��P[w],w����V-S
					D[w] = min + G.getArcs()[v][w];
					P[w].clear();
					while (!P[v].isEmpty()) {
						temp.offer(P[v].peek());
						P[w].offer(P[v].poll());
					}
					while (!temp.isEmpty())
						P[v].offer(temp.poll());

					P[w].offer(w);
				}
		}

	}

	public int[] getD() {
		return D;
	}

	public LinkQueue[] getP() {
		return P;
	}

}
