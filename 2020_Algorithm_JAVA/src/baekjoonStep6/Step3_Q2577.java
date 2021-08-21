package baekjoonStep6;

import java.util.Scanner;

public class Step3_Q2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int num = a*b*c;
		String n = Integer.toString(num);
		int[] arr = new int[n.length()];
		for(int i=0; i<n.length(); i++) {
			arr[i] = n.charAt(i) - '0';
		}
		int arr2[] = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0; i<n.length(); i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr[i] == j) {
					arr2[j]++;
				}
			}
		}
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}
}
