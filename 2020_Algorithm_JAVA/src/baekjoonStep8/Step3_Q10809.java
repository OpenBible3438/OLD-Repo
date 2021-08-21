package baekjoonStep8;

import java.util.Scanner;

public class Step3_Q10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int alpha[] = new int[26];
		for(int i=0; i<alpha.length; i++) {
			alpha[i] = -1;
		}
		for(int i=0; i<word.length(); i++) {
			int alphabet = word.charAt(i)-'a';
			if(alpha[alphabet] == -1) {
				alpha[alphabet] = i;	
			}
			
		}
		for(int i=0; i<alpha.length; i++) {
			System.out.print(alpha[i]+" ");
		}
	}
}