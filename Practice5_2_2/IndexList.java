package Practice5_2_2;

public class IndexList {
	private IndexNode[] r;
	private int curlen;

	public IndexList() {
		curlen = 0;
		r = new IndexNode[10];
	}

	public void insert(IndexNode N, int i) {
		r[i] = N;
		curlen++;
	}

	public void fenKuaiSearch(int key) {
		Node temp;
		int i = 1;
		int j = 1;// ����λֵ����ʼΪ1
		while (i < r.length) {
			if (r[i] != null) {
				temp = r[i].getHead().getNext();
				if (r[i].getMaxKey() >= key) {
					while (temp != null) {
						if (temp.getKey() == key) {
							System.out.println("�ؼ���" + key + "����������Ϊ��" + i + "    ����λ����ţ���ʼ���Ϊ1��Ϊ��" + j);
							return;
						} else {
							j++;
							temp = temp.getNext();
						}
					}
					System.out.println("���飬�޴˹ؼ��֣�");
				} else
					i++;
			} else if (r[i] == null) {
				System.out.println("���飬�޴˹ؼ��֣�");
				return;
			}

		}
	}
}
