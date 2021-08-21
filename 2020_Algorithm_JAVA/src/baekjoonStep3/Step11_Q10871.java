package baekjoonStep3;

import java.util.Scanner;

public class Step11_Q10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수열 안에 들어가는 정수들의 개수
		int[] arrA = new int[n]; //n개의 정수를 받는 수열 A
		int x = sc.nextInt(); //기준이 되는 수 X
		for(int i = 0; i<n; i++) {
			arrA[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(arrA[i] < x)
				System.out.print(arrA[i]+" ");
		}
	}
}
