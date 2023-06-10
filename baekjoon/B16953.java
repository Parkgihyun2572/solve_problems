/*
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

예제 입력 1 
2 162
예제 출력 1 
5
2 → 4 → 8 → 81 → 162

예제 입력 2 
4 42
예제 출력 2 
-1
예제 입력 3 
100 40021
예제 출력 3 
5
100 → 200 → 2001 → 4002 → 40021
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16953 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int count = 1;
		
		while(b > a) { // 아래 과정 반복 중 b가 a 이하가 되면 탈출
			// 2의 배수인지 확인
			boolean isBMultipleOf2 = (b % 2 == 0);
			if(isBMultipleOf2) {	// 맞다면 2로 나눔
				b = b/2;
			} else {				// 아니면 문자열로 바꾸어 마지막 숫자가 1인지 확인
				if(b % 10 == 1) {
					String bStr = Integer.toString(b);
					char bLastChar = bStr.charAt(bStr.length() - 1);
					if(bLastChar == '1') {	// 마지막 숫자가 1이 맞으면 그 전까지 자름
						bStr = bStr.substring(0, bStr.length() - 1);
					}
					b = Integer.parseInt(bStr);
				} else {
					break;
				}
			}
			count++;			
		}
		
		if(b == a) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}
