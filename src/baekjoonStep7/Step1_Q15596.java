package baekjoonStep7;

import java.util.Scanner;

public class Step1_Q15596 {
	static long sum(int[] a) {
		long sum=0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum; 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(sum(num));
	}
}
