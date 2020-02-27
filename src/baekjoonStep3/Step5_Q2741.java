package baekjoonStep3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Step5_Q2741 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		for(int i=1; i<=n; i++) {
			bw.write(Integer.toString(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}