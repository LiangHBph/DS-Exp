package Practice2_1_3;

import java.util.Scanner;

public class Sy3_1_3 {
 
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入行数和列数：");
		int m=scanner.nextInt();
		int n=scanner.nextInt();
//根据输入的行列数构造一个map
        map pMap=new map(m, n);
        LinkedStack L1=pMap.search();;                
//将栈逆置并输出
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
//输出路线图，2为尝试过的路线
        System.out.println();
        System.out.println("\n输出路线图，2代表尝试过的路线:");
        for (int i = 1; i < 10; i++) {
	         for (int j = 1; j < 9; j++) {
	        	 System.out.print(pMap.map[i][j]+" ");
			}
	         System.out.println();
		}
	}
}
//书上提供的迷宫图               
//	   0 0 1 0 0 0 1 0              
//	   0 0 1 0 0 0 1 0              
//	   0 0 0 0 1 1 0 1              
//	   0 1 1 1 0 0 1 0             
//	   0 0 0 1 0 0 0 0              
//	   0 1 0 0 0 1 0 1             
//	   0 1 1 1 1 0 0 1              
//	   1 1 0 0 0 1 0 1             
//	   1 1 0 0 0 0 0 0  


//死路测试
//     0 0 1 0 0 0 1 0 
//     0 0 1 0 0 0 1 0
//     0 0 0 0 1 1 0 1
//     0 1 1 1 0 0 1 0
//     0 0 0 1 0 0 0 0
//     0 1 0 0 0 1 0 1
//     0 1 1 1 1 0 0 1 
//     1 1 0 0 0 1 1 1
//     1 1 0 0 0 0 0 0

