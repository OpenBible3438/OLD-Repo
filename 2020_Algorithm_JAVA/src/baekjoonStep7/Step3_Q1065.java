package baekjoonStep7;

import java.util.Scanner;

public class Step3_Q1065 {
	static int hansu(int n) {
		int count=0;
		int one, ten, hund;
		if(n < 100) return n;
		else {
			count=99;
			for(int i=100; i<=n; i++) {
				hund = i/100;
				ten = (i/10)%10;
				one = i%10;
				if((hund-ten) == (ten-one))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.print(hansu(num));
	}

}