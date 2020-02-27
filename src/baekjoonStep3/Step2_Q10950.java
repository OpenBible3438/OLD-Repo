package baekjoonStep3;

import java.util.Scanner;

public class Step2_Q10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //테스트케이스 t
		int result[] = new int[t];
		for(int i=0; i<t; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			result[i] = num1+num2;
		}
		for(int j=0; j<t; j++) {
			System.out.println(result[j]);
		}
	}
}