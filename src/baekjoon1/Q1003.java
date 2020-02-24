package baekjoon1;

import java.util.Scanner;

public class Q1003 {
	static int count0 = 0;
	static int count1 = 0;
	
	static int fibo(int n) {
		if(n == 0) {
			count0++;
			return 0;
		}
		else if(n == 1) {
			count1++;
			return 1;
		}
		else 
			return fibo(n-1) + fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0; i<count; i++) {
			count0=0;
			count1=0;
			int num = sc.nextInt();
			fibo(num);
			System.out.println(count0+" "+count1);
		}
	}
}
