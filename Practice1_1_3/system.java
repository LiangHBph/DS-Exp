package Practice1_1_3;

public class system {
	public student[] List = null;
	// ����˳���ṹ
    int cur=0;
	// ����Ҫ��ʵ�ֵ���������
	public student[] build(int n) {// ��Ҫ����ѧ������
		List = new student[3*n];//����3N������ֹ������ݵ������
		return List;
	}
	public void insert(int i, student x) {
		List[i] = x;
		cur++;
	}
	public int getThroughNumber(student List[], int number) {
		int i = 0;
		while (i < List.length && List[i].number!=number)
			i++;
		if (i < List.length) {
			return i;
		} else {
			System.out.println("���޴���");
			return -1;
		}
	}
	public int getThroughName(student List[], String name) {
		int i = 0;
		while (i < List.length && !List[i].name.equals(name))
			i++;
		if (i < List.length) {
			return i;
		} else {
			System.out.println("���޴���");
			return -1;
		}
	}
	public student[] removeThroughNumber(int number,student List[]) {
		int j=getThroughNumber(List, number);
	
		for (int i = j; i < cur; i++) {
			List[i]=List[i+1];
		}
		cur--;
		System.out.println("ɾ����ɣ�");
		return List;
	}//preNumber��ѧ��
	public student[] changeThroughNumber(int preNumber,int grades) {
		int j=getThroughNumber(List, preNumber);
		List[j].grades=grades;
		System.out.println("�޸ĺ�����ϢΪ��");
		List[j].display();
		return List;
	}
	public void display() {
		for (int i = 0; i < cur; i++) {
			List[i].display();
		}
	}
}
