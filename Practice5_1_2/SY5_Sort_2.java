package Practice5_1_2;


public class SY5_Sort_2 extends SeqList{
	

	
	
	public SY5_Sort_2(int maxSize) {
		super(maxSize);
	}
	
	
    public static long testSortTime(SeqList L,int sortmethod) {
		long starTime,endTime,testTime;
		starTime=System.currentTimeMillis();
		switch (sortmethod) {
		case 0:
			L.bubbleSort();
			break;

		case 1:
			L.quickSort();
			break;
		}
		endTime=System.currentTimeMillis();
		testTime=endTime-starTime;
		return testTime;
	}
   
    
    
    private static SeqList createList(int [] d)throws Exception {
	    SeqList L=new SY5_Sort_2(10001);
	    for (int  i= 0; i < d.length; i++) {
			RecordNode r=new RecordNode(d[i]);
			L.insert(L.length(), r);
		}
		L.insert(0, new RecordNode(0));
		return L;
	}
    



	public static void main(String[] args) throws Exception {
        int [] d= new int [10000];
        for (int i = 0; i < d.length; i++) {
			d[i]=(int)(Math.random()*10000);
		}
       
        SeqList L0=createList(d);
        L0.set();
        long a=testSortTime(L0, 0);
        
        System.out.println("冒泡排序：");
        System.out.println("比较次数："+L0.cm[0].getCpn()+"  移动次数："+L0.cm[0].getMvn()+"  用时："+a+"毫秒");
        L0=createList(d);
        L0.set();
        a=testSortTime(L0, 1);
        System.out.println("快速排序：");
        System.out.println("比较次数："+L0.cm[1].getCpn()+"  移动次数："+L0.cm[1].getMvn()+"  用时："+a+"毫秒");
	}

}
