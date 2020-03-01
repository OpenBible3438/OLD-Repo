package baekjoonStep6;

import java.util.Scanner;

public class Step2_Q2562 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];
		int maxIndex = 0;
		for(int j=1; j<arr.length; j++) {
			if(arr[j] > max) {
				max = arr[j];
				maxIndex = j+1;
			}
		}
		System.out.println(max);
		System.out.print(maxIndex);
	}
}