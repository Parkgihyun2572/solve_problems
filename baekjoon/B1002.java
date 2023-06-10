/*
# 백준 1002 터렛

문제
조규현과 백승환은 터렛에 근무하는 직원이다.
하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다.
다음은 조규현과 백승환의 사진이다.

이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
한 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고,
r1, r2는 10,000보다 작거나 같은 음이 아닌 정수이다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다.
만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

예제 입력 1 
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5

3
0 0 1 0 0 1
0 0 5 3 4 3
0 0 7 1 2 1

예제 출력 1 
2
1
0
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002 {
	
	public static void main(String[] args) throws IOException {
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfCases = Integer.parseInt(br.readLine());
		int[] testResult = new int[numberOfCases];
		
		for(int i = 0; i < numberOfCases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] testCase = new int[6];
			for (int j = 0; j < testCase.length; j++) {
				testCase[j] = Integer.parseInt(st.nextToken());
			}
			int x1 = testCase[0];
			int y1 = testCase[1];
			int r1 = testCase[2];
			int x2 = testCase[3];
			int y2 = testCase[4];
			int r2 = testCase[5];
			
			double distance = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
			int sumOfRadius = r2 + r1;
			int minusOfRadius = Math.abs(r2 - r1);
			
			if(distance == 0 && minusOfRadius == 0) {
				testResult[i] = -1;
			} else if(sumOfRadius == distance || minusOfRadius == distance) {
				testResult[i] = 1;
			} else if(sumOfRadius > distance && minusOfRadius < distance) {
				testResult[i] = 2;
			} else{
				testResult[i] = 0;
			}
		}

		for (int i = 0; i < testResult.length; i++) {
			System.out.println(testResult[i]);
		}
	}
}
