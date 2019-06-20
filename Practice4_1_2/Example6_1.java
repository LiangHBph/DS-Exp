package Practice4_1_2;

//����6.1�����ʵ��Ӧ�ù�����������㷨ȷ������ͼ����ͨ������


public class Example6_1 {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static void CC_BFS(IGraph G) throws Exception {
		boolean[] visited = new boolean[G.getVexNum()];// ���ʱ�־����
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		LinkQueue Q = new LinkQueue();// ��������Q
		LinkQueue P = new LinkQueue();// ��������P,���ڼ�¼��ͨ�����Ķ���
		int i = 0;// ���ڼ�����ͨ�����ĸ���
		for (int v = 0; v < G.getVexNum(); v++) {
			P.clear();// �������
			if (!visited[v]) {// v��δ����
				visited[v] = true;
				P.offer(G.getVex(v));
				Q.offer(v);// v�����
				while (!Q.isEmpty()) {
					int u = (Integer) Q.poll();// ��ͷԪ�س����в���ֵ��u
					for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u,
							w)) {
						if (!visited[w]) {// wΪu����δ���ʵ��ڽӶ���
							visited[w] = true;
							P.offer(G.getVex(w));
							Q.offer(w);
						}
					}
				}
				System.out.println("ͼ�ĵ�" + ++i + "����ͨ����Ϊ��");
				while (!P.isEmpty())
					System.out.print(P.poll().toString() + " ");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		
		MGraph G = new MGraph(GraphKind.UDG, 0, 0, null, null);
		G.createGraph();
		CC_BFS(G);
	}
}
// ���Խ����
// ͼ�ĵ�1����ͨ����Ϊ��
// A B D C
// ͼ�ĵ�2����ͨ����Ϊ��
// E F G
