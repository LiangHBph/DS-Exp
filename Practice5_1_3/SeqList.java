package Practice5_1_3;

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


    //���㷨7.2���������ڵ�ֱ�Ӳ��������㷨
    public void insertSortWithGuard() {

        int i, j;
        System.out.println("�������ڵ�ֱ�Ӳ�������");
        for (i = 1; i < this.curlen; i++) {//n-1��ɨ��
            r[0] = r[i]; //��������ĵ�i����¼�ݴ���r[0]�У�ͬʱr[0]Ϊ������
            for (j = i - 1; r[0].getKey().compareTo(r[j].getKey()) < 0; j--) { //��ǰ��ϴ�Ԫ������ƶ�
                r[j + 1] = r[j];
            }
            r[j + 1] = r[0];          // r[i]���뵽��j+1��λ��
       //     System.out.println("��" + i + "��: ");
       //     display();
        }
    }

 
 
    //���㷨7.4�� ð�������㷨
    public void bubbleSort() {
    //    System.out.println("ð������");
        RecordNode temp;       //�������
        boolean flag = true;   //�Ƿ񽻻��ı��
        for (int i = 1; i < this.curlen && flag; i++) { //�н���ʱ�ٽ�����һ�ˣ����n-1��
            flag = false;                              //�ٶ�Ԫ��δ����
            for (int j = 0; j < this.curlen - i; j++) { //һ�αȽϡ�����
                if (r[j].getKey().compareTo(r[j + 1].getKey()) > 0) {     //����ʱ������
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    flag = true;
                }
            }
         //   System.out.print("��" + i + "��: ");
         //   display();
        }
    }

    //���㷨7.5��һ�˿�������
    //���������r[i..j]�ļ�¼��ʹ֧���¼��λ��������������λ��
    //��ʱ����֧��֮ǰ(��)�ļ�¼�ؼ��־�������(С��)��
    public int Partition(int i, int j) {
        RecordNode pivot = r[i];          //��һ����¼��Ϊ֧���¼
    //    System.out.print(i + ".." + j + ",  pivot=" + pivot.getKey() + "  ");
        while (i < j) {    //�ӱ�����˽�������м�ɨ��
            while (i < j && pivot.getKey().compareTo(r[j].getKey()) <= 0) {
                j--;
            }
            if (i < j) {
                r[i] = r[j];   //����֧���¼�ؼ���С�ļ�¼��ǰ�ƶ�
                i++;
            }
            while (i < j && pivot.getKey().compareTo(r[i].getKey()) > 0) {
                i++;
            }
            if (i < j) {
                r[j] = r[i];   //����֧���¼�ؼ��ִ�ļ�¼����ƶ�
                j--;
            }
        }
        r[i] = pivot;         //֧���¼��λ
    //    display();
        return i;             //����֧��λ��
    }

    //���㷨7.6�� �ݹ���ʽ�Ŀ��������㷨
    //���ӱ�r[low..high]��������
    public void qSort(int low, int high) {
        if (low < high) {
            int pivotloc = Partition(low, high);  //һ�����򣬽�������Ϊ������
            qSort(low, pivotloc - 1);   //���ӱ�ݹ�����
            qSort(pivotloc + 1, high);  //���ӱ�ݹ�����
        }
    }

    //���㷨7.7��˳�����������㷨
    public void quickSort() {
        qSort(0, this.curlen - 1);
    }

    //���㷨7.8��ֱ��ѡ������
    public void selectSort() {
     //   System.out.println("ֱ��ѡ������");
        RecordNode temp; //�������
        for (int i = 0; i < this.curlen - 1; i++) {//n-1������
            //ÿ���ڴ�r[i]��ʼ����������Ѱ����СԪ��
            int min = i;               //���i����¼�Ĺؼ�����С
            for (int j = i + 1; j < this.curlen; j++) {//����������ѡ��ؼ�����С�ļ�¼
                if (r[j].getKey().compareTo(r[min].getKey()) < 0) {
                    min = j;             //��ס�ؼ�����С��¼���±�
                }
            }
            if (min != i) {    //�����˹ؼ�����С�ļ�¼���i����¼����
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        //    System.out.print("��" + (i + 1) + "��: ");
        //    display();
        }
    }

  
}
