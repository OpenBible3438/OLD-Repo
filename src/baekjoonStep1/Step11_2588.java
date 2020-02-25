package baekjoonStep1;

import java.util.Scanner;
public class Step11_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int num1 = sc.nextInt();
		String str2 = sc2.nextLine();
		int num3 = Integer.parseInt(str2);
		int num2[]= new int[3];
		for(int i=0; i<str2.length(); i++) {
			num2[i]=str2.charAt(i) - '0';
		}
		for(int i=2; i>0; i--) {
			System.out.println(num1*num2[i]);
		}
		System.out.println(num1*num3);
	}
}
