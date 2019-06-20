package Practice1_1_3;

public class system {
	public student[] List = null;
	// 定义顺序表结构
    int cur=0;
	// 定义要求实现的六个方法
	public student[] build(int n) {// 需要传入学生人数
		List = new student[3*n];//建立3N个，防止添加数据导致溢出
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
			System.out.println("查无此人");
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
			System.out.println("查无此人");
			return -1;
		}
	}
	public student[] removeThroughNumber(int number,student List[]) {
		int j=getThroughNumber(List, number);
	
		for (int i = j; i < cur; i++) {
			List[i]=List[i+1];
		}
		cur--;
		System.out.println("删除完成！");
		return List;
	}//preNumber是学号
	public student[] changeThroughNumber(int preNumber,int grades) {
		int j=getThroughNumber(List, preNumber);
		List[j].grades=grades;
		System.out.println("修改后其信息为：");
		List[j].display();
		return List;
	}
	public void display() {
		for (int i = 0; i < cur; i++) {
			List[i].display();
		}
	}
}
