package Practice5_2_3;

/**
 * ��7�� ˳�����
 */
public class SeqList {

    private RecordNode[] r;    //˳����¼�������
    private int curlen;        //˳�����,����¼����

    public RecordNode[] getRecord() {
        return r;
    }

    public void setRecord(RecordNode[] r) {
        this.r = r;
    }

    public SeqList(){}
    
    // ˳���Ĺ��췽��������һ���洢�ռ�����ΪmaxSize��˳���
    public SeqList(int maxSize) {
        this.r = new RecordNode[maxSize];  // Ϊ˳������maxSize���洢��Ԫ
        this.curlen = 0;                   // ��˳���ĵ�ǰ����Ϊ0
    }

    // ��˳����е�����Ԫ�ظ������ɺ���������ֵ
    public int length() {
        return curlen; // ����˳���ĵ�ǰ����
    }

    // �ڵ�ǰ˳���ĵ�i�����֮ǰ����һ��RecordNode���͵Ľ��x
    //����iȡֵ��ΧΪ��0��i��length()��
    //���iֵ���ڴ˷�Χ���׳��쳣,��i=0ʱ��ʾ�ڱ�ͷ����һ������Ԫ��x,
    //��i=length()ʱ��ʾ�ڱ�β����һ������Ԫ��x
    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) {    // �ж�˳����Ƿ�����
            throw new Exception("˳�������");
        }
        if (i < 0 || i > curlen) {  // iС��0���ߴ��ڱ�
            throw new Exception("����λ�ò�����");
        }
        for (int j = curlen; j > i; j--) {
            r[j] = r[j - 1];   // ����λ�ü�֮���Ԫ�غ���
        }
        r[i] = x;   // ����x
        this.curlen++;  // ������1
    }

    public void display() {    //�������Ԫ��
        for (int i = 0; i < this.curlen; i++) {
            System.out.print(" " + r[i].getKey().toString());
        }
        System.out.println();
    }
    
    //���ֲ���
    public int binarySearch(Comparable key) {
        if (length() > 0) {
            int low = 0, high = length() - 1; //���ҷ�Χ���½���Ͻ�
            while (low <= high) {
                int mid = (low + high) / 2;   //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
                //    System.out.print(r[mid].getKey() + "? ");
                if (r[mid].getKey().compareTo(key) == 0) {
                    return mid;                                //���ҳɹ�
                } else if (r[mid].getKey().compareTo(key) > 0) { //����ֵ��С
                    high = mid - 1;     //���ҷ�Χ��С��ǰ���
                } else {
                    low = mid + 1;      //���ҷ�Χ��С������
                }
            }
        }
        return -1;  //���Ҳ��ɹ�
    }

   
}
