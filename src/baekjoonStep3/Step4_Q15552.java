package baekjoonStep3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Step4_Q15552 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine());
		int arrNum[] = new int[t];
		for(int i=0; i<t; i++) {
			String strNum = bf.readLine();
			StringTokenizer st = new StringTokenizer(strNum);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arrNum[i] = num1+num2;
		}
		for(int j=0; j<t; j++) {
			bw.write(Integer.toString(arrNum[j])+"\n");
		}
		bw.flush();
		bw.close();
	}
}
