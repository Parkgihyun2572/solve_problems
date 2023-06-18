package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11726 {
	static int num;
	static long answer;
	static final int MAX = 1000;
	static long[] dp = new long [MAX + 1];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		
//		answer = bottomUp(num);
		answer = topDown(num);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();		
	}
	
	static long bottomUp(int n) {
		if(n > 2) {
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;	//왜 여기서 10007을 나눠서 저장하는거지..?
			}
			return dp[n];
		} else {
			return dp[n];
		}
	}
	
	static long topDown(int n) {
		if(n < 3) {
			return dp[n];
		} else if(dp[n] > 0) {
			return dp[n];
		}
		
		dp[n] = (topDown(n - 1) + topDown(n - 2)) % 10007;
		return dp[n];
	}
}
