package baekjoonStep4;

import java.util.Scanner;

public class Step1_Q10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		while(num1!=0 && num2!=0) {
			System.out.println(num1+num2);
			num1 = sc.nextInt();
			num2 = sc.nextInt();
		}
	}
}
