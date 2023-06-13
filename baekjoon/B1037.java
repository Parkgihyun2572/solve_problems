package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfDivisors = Integer.parseInt(br.readLine());
		
		int[] divisors = new int[numberOfDivisors];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < divisors.length; i++) {
			divisors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(divisors);
		
		int answer = divisors[0] * divisors[divisors.length - 1];
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
