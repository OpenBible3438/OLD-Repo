package baekjoonStep2;

import java.util.Scanner;

public class Step4_Q2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); //½Ã
		int m = sc.nextInt(); //ºÐ
		if(m >= 45) {
			m = m - 45;
			System.out.println(h+" "+m);
		}
		else {
			m = 45 - m;
			m = 60 - m;
			h = h - 1;
			if(h == -1) {
				h = 23;
			}
			System.out.println(h+" "+m);
		}
	}
}