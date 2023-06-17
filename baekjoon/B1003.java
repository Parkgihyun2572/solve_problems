package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
	
public class B1003 {
	
	static int[][] topDownMemo;
	static int[][] bottomUpMemo;
	static final int MAXTESTCOUNT = 40;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfTests = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numberOfTests; i++) {
			
			topDownMemo = new int[MAXTESTCOUNT + 1][2]; 
			bottomUpMemo = new int[MAXTESTCOUNT + 1][2]; 

			int givenNum = Integer.parseInt(br.readLine());
//			int[] answer = topDownFibonacci(givenNum);
			int[] answer = bottomUpFibonacci(givenNum);
			
			bw.write(String.valueOf(answer[0]) + " ");
			bw.write(String.valueOf(answer[1]) + "\n");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	// DP Top-Down을 사용
	static int[] topDownFibonacci(int givenNum) {
		// 기저 상태 사전 저장
		topDownMemo[0][0] = 1;
		topDownMemo[0][1] = 0;
		topDownMemo[1][0] = 0;
		topDownMemo[1][1] = 1;
		
		if(givenNum < 2) {
			// 기저값 도달시, 사전값 반환
			return topDownMemo[givenNum];
		} else if(topDownMemo[givenNum][0] > 0 && topDownMemo[givenNum][1] > 0) {
			// 메모에 계산된 값이 있으면 바로 반환
			return topDownMemo[givenNum];
		}
		
		// 재귀를 사용
		topDownMemo[givenNum][0] = topDownMemo[givenNum - 1][0] + topDownMemo[givenNum - 2][0];
		topDownMemo[givenNum][1] = topDownMemo[givenNum - 1][1] + topDownMemo[givenNum - 2][1];
		
		return topDownMemo[givenNum];
	}
	
	// DP Bottom-Up을 사용
	static int[] bottomUpFibonacci(int givenNum) {
		// 기저 상태 사전 저장
		bottomUpMemo[0][0] = 1;
		bottomUpMemo[0][1] = 0;
		bottomUpMemo[1][0] = 0;
		bottomUpMemo[1][1] = 1;
		
		// 반복문을 통해 table을 채워나감
		for(int i = 2; i <= givenNum; i++) {
			bottomUpMemo[i][0] = bottomUpMemo[i - 1][0] + bottomUpMemo[i - 2][0];
			bottomUpMemo[i][1] = bottomUpMemo[i - 1][1] + bottomUpMemo[i - 2][1];
		}
		
		return bottomUpMemo[givenNum];
	}
}
