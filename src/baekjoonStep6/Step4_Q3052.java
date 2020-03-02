package baekjoonStep6;

import java.util.Scanner;

public class Step4_Q3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int arr42[] = new int[42];
		int count=0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			int per = arr[i]%42;
			arr42[per] = 1;
		}
		for(int i=0; i<arr42.length; i++) {
			if(arr42[i] == 1)
				count++;
		}
		System.out.print(count);
	}
}
