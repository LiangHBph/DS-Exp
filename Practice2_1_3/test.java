package Practice2_1_3;

import java.io.IOException;
import java.util.Scanner;

import Practice1_1_3.system;

public class test {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[^0123456789.]+");
		System.out.println("������·�����꣬ʾ������3��2��");
		while (sc.hasNextInt()) {
			System.in.close();
			System.out.println(sc.nextInt());
		}
		System.out.println("ending");
	}

}
