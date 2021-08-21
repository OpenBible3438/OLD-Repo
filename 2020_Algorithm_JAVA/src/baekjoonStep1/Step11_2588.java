package baekjoonStep1;

import java.util.Scanner;
public class Step11_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3, num4, num5, num6; //문제에서 3,4,5,6 위치에 들어가는 변수
		num6 = num1 * num2;
		num3 = num1*(num2%10);
		num2 = num2/10;
		num4 = num1*(num2%10);
		num2 = num2/10;
		num5 = num1 * num2;
		System.out.printf("%d\n%d\n%d\n%d\n", num3, num4, num5, num6);
	}
}
