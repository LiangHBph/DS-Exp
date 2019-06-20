package Practice5_1_2;

/**
 * 第7章 顺序表类
 */
public class SeqList {

    private RecordNode[] r;    //顺序表记录结点数组
    private int curlen;        //顺序表长度,即记录个数

    public RecordNode[] getRecord() {
        return r;
    }

    public void setRecord(RecordNode[] r) {
        this.r = r;
    }
	CopareMoveNum [] cm=new CopareMoveNum[2];
	public CopareMoveNum[] set() {
		cm[0]=new CopareMoveNum();
		cm[1]=new CopareMoveNum();
		return cm;
	}
	
	
    public SeqList(){}
    
    // 顺序表的构造方法，构造一个存储空间容量为maxSize的顺序表
    public SeqList(int maxSize) {
        this.r = new RecordNode[maxSize];  // 为顺序表分配maxSize个存储单元
        this.curlen = 0;                   // 置顺序表的当前长度为0
    }

    // 求顺序表中的数据元素个数并由函数返回其值
    public int length() {
        return curlen; // 返回顺序表的当前长度
    }

    // 在当前顺序表的第i个结点之前插入一个RecordNode类型的结点x
    //其中i取值范围为：0≤i≤length()。
    //如果i值不在此范围则抛出异常,当i=0时表示在表头插入一个数据元素x,
    //当i=length()时表示在表尾插入一个数据元素x
    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) {    // 判断顺序表是否已满
            throw new Exception("顺序表已满");
        }
        if (i < 0 || i > curlen) {  // i小于0或者大于表长
            throw new Exception("插入位置不合理");
        }
        for (int j = curlen; j > i; j--) {
            r[j] = r[j - 1];   // 插入位置及之后的元素后移
        }
        r[i] = x;   // 插入x
        this.curlen++;  // 表长度增1
    }

    public void display() {    //输出数组元素
        for (int i = 0; i < this.curlen; i++) {
            System.out.print(" " + r[i].getKey().toString());
        }
        System.out.println();
    }

   

    //【算法7.4】 冒泡排序算法
    public void bubbleSort() {
    //    System.out.println("冒泡排序");
    	
        RecordNode temp;       //辅助结点
        boolean flag = true;   //是否交换的标记
        for (int i = 1; i < this.curlen && flag; i++) { //有交换时再进行下一趟，最多n-1趟
            flag = false;                              //假定元素未交换
            for (int j = 0; j < this.curlen - i; j++) { //一次比较、交换
            	cm[0].setCpn(cm[0].getCpn()+1);
                if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) {     //逆序时，交换
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    flag = true;
                    cm[0].setMvn(cm[0].getMvn()+3);
                }
            }
         //   System.out.print("第" + i + "趟: ");
         //   display();
        }
    }

    //【算法7.5】一趟快速排序
    //交换排序表r[i..j]的记录，使支点记录到位，并返回其所在位置
    //此时，在支点之前(后)的记录关键字均不大于(小于)它

    public int Partition(int i, int j) {
    	cm[1].setMvn(cm[1].getMvn()+1);
        RecordNode pivot = r[i];          //第一个记录作为支点记录
    //    System.out.print(i + ".." + j + ",  pivot=" + pivot.getKey() + "  ");
        while (i < j) {    //从表的两端交替地向中间扫描
            while (i < j && pivot.getKey().compareTo(r[j].getKey()) <= 0) {
                j--;
                cm[1].setCpn(cm[1].getCpn()+1);
            }
            if (i < j) {
                r[i] = r[j];   //将比支点记录关键字小的记录向前移动
                i++;
                cm[1].setMvn(cm[1].getMvn()+1);
                
            }
            while (i < j && pivot.getKey().compareTo(r[i].getKey()) > 0) {
                i++;
                cm[1].setCpn(cm[1].getCpn()+1);
                
            }
            if (i < j) {
                r[j] = r[i];   //将比支点记录关键字大的记录向后移动
                j--;
                cm[1].setMvn(cm[1].getMvn()+1);
                
            }
        }
        r[i] = pivot;         //支点记录到位
    //    display();
        cm[1].setMvn(cm[1].getMvn()+1);
        return i;             //返回支点位置
    }

    //【算法7.6】 递归形式的快速排序算法
    //对子表r[low..high]快速排序
    public void qSort(int low, int high) {
        if (low < high) {
            int pivotloc = Partition(low, high);  //一趟排序，将排序表分为两部分
            qSort(low, pivotloc - 1);   //低子表递归排序
            qSort(pivotloc + 1, high);  //高子表递归排序
        }
    }

    //【算法7.7】顺序表快速排序算法
    public void quickSort() {
        qSort(0, this.curlen - 1);
    }



  

}
