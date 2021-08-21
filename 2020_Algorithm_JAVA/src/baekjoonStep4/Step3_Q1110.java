package baekjoonStep4;

import java.util.Scanner;

public class Step3_Q1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int firstNum=input;
		int count = 0;
		int ten, one, sum, newNum;
		while(true) {
			if(input < 10) {
				ten=0;
				one=input;
			}
			else {
				ten=input/10;
				one=input%10;
			}
			sum = ten+one;
			newNum = (one*10)+(sum%10);
			count++;
			if(firstNum == newNum) break;
			input = newNum;
		}
		System.out.println(count);
	}
}