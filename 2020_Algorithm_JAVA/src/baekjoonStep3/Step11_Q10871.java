package baekjoonStep3;

import java.util.Scanner;

public class Step11_Q10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //���� �ȿ� ���� �������� ����
		int[] arrA = new int[n]; //n���� ������ �޴� ���� A
		int x = sc.nextInt(); //������ �Ǵ� �� X
		for(int i = 0; i<n; i++) {
			arrA[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(arrA[i] < x)
				System.out.print(arrA[i]+" ");
		}
	}
}
