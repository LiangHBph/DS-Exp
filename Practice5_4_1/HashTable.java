package Practice5_4_1;

public class HashTable {
	private RecordNode[] table;

	public HashTable(int size) {
		this.table = new RecordNode[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new RecordNode(0);
		}
	}

	public int hash(int key) {
		return key % 19;
	}

	public RecordNode hashSearch(int key) {
		int i = hash(key);
		int j = 0;
		while ((table[i].getKey().compareTo(0)) != 0 && (table[i].getKey().compareTo(key)) != 0 && j < table.length) {
            j++;
            i=(i+j)%20;
		}
		if (j>=table.length) {
			System.out.println("��ϣ������");
			return null;
		} else {
            return table[i];
		}

	}
	public void hashInsert(int key) {
		RecordNode p=hashSearch(key);

		if (p.getKey().compareTo(0)==0) {
			p.setKey(key);
		} else {
            System.out.println("�˹ؼ��ּ�¼�Ѵ��ڻ��ϣ������");
		}
		
	}
	void HashDisplay() {
		for (int i = 0; i < table.length; i++) {
			System.out.print(table[i].getKey().toString()+" ");
		}
		System.out.println();
	}
}
