package Practice5_2_3;

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
    
    //二分查找
    public int binarySearch(Comparable key) {
        if (length() > 0) {
            int low = 0, high = length() - 1; //查找范围的下界和上界
            while (low <= high) {
                int mid = (low + high) / 2;   //中间位置，当前比较元素位置
                //    System.out.print(r[mid].getKey() + "? ");
                if (r[mid].getKey().compareTo(key) == 0) {
                    return mid;                                //查找成功
                } else if (r[mid].getKey().compareTo(key) > 0) { //给定值更小
                    high = mid - 1;     //查找范围缩小到前半段
                } else {
                    low = mid + 1;      //查找范围缩小到后半段
                }
            }
        }
        return -1;  //查找不成功
    }

   
}
