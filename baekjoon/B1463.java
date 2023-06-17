package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1463 {
	
	static int num, answer;
	static int[] dp;
	static final int MAXNUM = 1000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = Integer.parseInt(br.readLine());
		
		dp = new int[MAXNUM + 1];
		dp[2] = 1;
		dp[3] = 1;
//		answer = bottomUp(num);
		answer = topDown(num);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int topDown(int n) {
		if(n < 3) {
			return dp[n];
		} else if(dp[n] > 1){
			return dp[n];
		} else{
			if(n % 6 == 0) {
				return dp[n] = Math.min(topDown(n / 3), Math.min(topDown(n / 2), topDown(n - 1))) + 1;
			} else if(n % 3 == 0) {
				return dp[n] = Math.min(topDown(n / 3), topDown(n - 1)) + 1;
			} else if(n % 2 == 0) {
				return dp[n] = Math.min(topDown(n / 2), topDown(n - 1)) + 1;
			} else {
				return dp[n] = topDown(n - 1) + 1;
			}
		}
	}
	
	static int bottomUp(int n) {
		if(n > 3) {
			for(int i = 4; i <= n; i++) {
				if(i % 6 == 0) {
					dp[i] = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1])) + 1;
				} else if(i % 3 == 0) {
					dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
				} else if(i % 2 == 0) {
					dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			}
		}
		return dp[n];			
	}
}
