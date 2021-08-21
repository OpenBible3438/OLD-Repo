package baekjoonStep3;

import java.util.Scanner;

public class Step8_Q11022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println("Case #"+(i+1)+": "+num1+" + "+num2+" = "+(num1+num2));
		}

	}
}
