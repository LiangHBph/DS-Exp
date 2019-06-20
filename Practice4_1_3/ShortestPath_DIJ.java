package Practice4_1_3;

public class ShortestPath_DIJ {
	private LinkQueue[] P;// p上挂链

	private int[] D;// v0到其余顶点的带权长度

	public final static int INFINITY = Integer.MAX_VALUE;

	// 用Dijkstra算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其权值D[v]

	LinkQueue temp = new LinkQueue();

	public void DIJ(MGraph G, int v0, int v2) {
		int vexNum = G.getVexNum();
		P = new LinkQueue[vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]为true当且仅当v属于S,即已经求得从v0到v的最短路径
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			P[v] = new LinkQueue();
			P[v].offer(v0);
			if (D[v] < INFINITY) {
				P[v].offer(v);
			}
		}

		D[v0] = 0;// 初始化，v0顶点属于S集
		finish[v0] = true;

		int v = -1;

		// 开始主循环，每次求得v0到某个v顶点的最短路径，并加v到S集
		for (int i = 1; i < vexNum; i++) {// 其余G.getVexNum-1个顶点
			int min = INFINITY;// 当前所知离v0顶点的最近距离
			for (int w = 0; w < vexNum; w++)
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			finish[v] = true;// 离v0顶点最近的v加入S集

			if (v == v2)
				return;

			for (int w = 0; w < vexNum; w++)
				// 更新当前最短路径及距离
				if (!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w] < D[w])) { // 修改D[w]和P[w],w属于V-S
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
