package baekjoonStep8;

import java.util.Scanner;

public class Step2_Q11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		String str = sc.next();
		for(int i=0; i<str.length(); i++) {
			sum += (str.charAt(i) - '0');
		}
		System.out.print(sum);
	}
}