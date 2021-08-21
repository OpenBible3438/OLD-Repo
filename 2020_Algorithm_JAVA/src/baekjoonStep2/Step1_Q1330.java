package baekjoonStep2;

import java.util.Scanner;

public class Step1_Q1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if(num1 > num2) {
			System.out.print(">");
		}
		else if (num1 < num2) {
			System.out.print("<");
		}
		else {
			System.out.print("==");
		}
	}
}
