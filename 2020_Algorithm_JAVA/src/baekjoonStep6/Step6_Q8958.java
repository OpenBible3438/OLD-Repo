package baekjoonStep6;

import java.util.Scanner;

public class Step6_Q8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int result[] = new int[t];
		for(int i=0; i<t; i++) {
			String s = sc.next();
			int score=0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == 'O') {
					score++;
					result[i] += score;
				}
				else if(s.charAt(j) == 'X') {
					score=0;
				}
			}
		}
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
	}
}