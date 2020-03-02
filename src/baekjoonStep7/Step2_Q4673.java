package baekjoonStep7;

public class Step2_Q4673 {
	static int d(int n) {
		int sum = n;
		while(true) {
			if(n == 0) break;
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		boolean arr[] = new boolean[10001];
	}
}
