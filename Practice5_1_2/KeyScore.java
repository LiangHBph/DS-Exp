package Practice5_1_2;

/**
 * ��7.1 ˳����¼���ؼ�����
 */
public class KeyScore implements Comparable<KeyScore> {

    private double score;   //�ؼ���

    public KeyScore(double score) {
        this.score = score;
    }

    public String toString() { //����toString()����
        return score + " ";
    }

    //����Comparable�ӿ��бȽϹؼ��ִ�С�ķ���compareTo
    public int compareTo(KeyScore another) {
        double thisVal = this.score;
        double anotherVal = another.score;
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
    }
}
