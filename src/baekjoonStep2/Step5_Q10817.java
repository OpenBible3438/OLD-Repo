package baekjoonStep2;

import java.util.Scanner;

public class Step5_Q10817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int secondNum = 0;
		if(a < b) {
			secondNum = a;
			if(a > c) {
				secondNum = a;
			}
			else if(b < c) {
				secondNum = b;
			}
			else
				secondNum = c;
		}
		else { // a > b
			secondNum = b;
			if(a < c) {
				secondNum = a;
			}
			else if(b > c) {
				secondNum = b;
			}
			else
				secondNum = c;
		}
		System.out.print(secondNum);
	}
}