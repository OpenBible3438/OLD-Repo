package baekjoonStep6;

import java.util.Scanner;

public class Step7_Q4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt(); //�׽�Ʈ ���̽�
		double avg[] = new double[c];
		for(int i=0; i<c; i++) {//�׽�Ʈ���̽� c��ŭ �ݺ�
			int n = sc.nextInt(); //�л��� ��
			int score[] = new int[n];
			double sum=0;
			for(int j=0; j<n; j++) {
				score[j] = sc.nextInt();
				sum += score[j];
			}
			avg[i] = sum/n;
			double stu=0;
			for(int j=0; j<n; j++) {
				if(avg[i] < score[j]) {
					stu++;
				}
			}
			double overStu = (stu*100)/n;
			System.out.printf("%.3f%%\n",overStu);
		}
	}
}
