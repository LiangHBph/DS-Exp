package Practice2_1_3;

import java.util.Scanner;

public class Sy3_1_3 {
 
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.print("������������������");
		int m=scanner.nextInt();
		int n=scanner.nextInt();
//�������������������һ��map
        map pMap=new map(m, n);
        LinkedStack L1=pMap.search();;                
//��ջ���ò����
        LinkedStack L2=new LinkedStack();
        while (!L1.isEmpty()) {
			L2.push(L1.pop());
		}
        while (!L2.isEmpty()) {
        	if (L2.length()%10==0) {
				System.out.println();
			}
        	System.out.print("("+((StackElem)L2.peek()).x+","+((StackElem)L2.peek()).y+","+((StackElem)L2.pop()).direc+") ");
        }
//���·��ͼ��2Ϊ���Թ���·��
        System.out.println();
        System.out.println("\n���·��ͼ��2�����Թ���·��:");
        for (int i = 1; i < 10; i++) {
	         for (int j = 1; j < 9; j++) {
	        	 System.out.print(pMap.map[i][j]+" ");
			}
	         System.out.println();
		}
	}
}
//�����ṩ���Թ�ͼ               
//	   0 0 1 0 0 0 1 0              
//	   0 0 1 0 0 0 1 0              
//	   0 0 0 0 1 1 0 1              
//	   0 1 1 1 0 0 1 0             
//	   0 0 0 1 0 0 0 0              
//	   0 1 0 0 0 1 0 1             
//	   0 1 1 1 1 0 0 1              
//	   1 1 0 0 0 1 0 1             
//	   1 1 0 0 0 0 0 0  


//��·����
//     0 0 1 0 0 0 1 0 
//     0 0 1 0 0 0 1 0
//     0 0 0 0 1 1 0 1
//     0 1 1 1 0 0 1 0
//     0 0 0 1 0 0 0 0
//     0 1 0 0 0 1 0 1
//     0 1 1 1 1 0 0 1 
//     1 1 0 0 0 1 1 1
//     1 1 0 0 0 0 0 0

