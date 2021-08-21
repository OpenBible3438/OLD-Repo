package baekjoonStep6;

import java.util.Scanner;

public class Step5_Q1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double score[] = new double[n];
		for(int i=0; i<score.length; i++) {
			score[i] = sc.nextDouble();
		}
		double max = score[0];
		for(int i=1; i<score.length; i++) {
			if(score[i] > max)
				max = score[i];
		}
		double sum=0;
		for(int i=0; i<score.length; i++) {
			sum += (score[i]*100)/max;
		}
		double avg = sum/n;
		System.out.printf("%.2f", avg);
	}
}
