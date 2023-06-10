/*
# Baekjoon 11047번 동전 0

# 문 제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

# 입 력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

# 출 력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

# 예제 입력
10 4200
1
5
10
50
100
500
1000
5000
10000
50000

# 예제 출력
6
 */

package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B11047 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 입력 받기
		int kindsOfCoins = scan.nextInt();
		int price = scan.nextInt();
		Integer [] kindsOfCoinsList = new Integer [kindsOfCoins];
		for (int i = 0; i < kindsOfCoinsList.length; i++) {
			kindsOfCoinsList[i] = scan.nextInt();
		}
		
		// 큰 단위부터 재정렬
		Arrays.sort(kindsOfCoinsList, Collections.reverseOrder());

		
		// 큰 단위부터 나누어가기
		int totalCount = 0;
		int count = 0;
		for (int i = 0; i < kindsOfCoinsList.length; i++) {
			if(price / kindsOfCoinsList[i] != 0) {
				count = price / kindsOfCoinsList[i];
				price -= count * kindsOfCoinsList[i];
				totalCount += count;
			}
		}
		System.out.println(totalCount);
		
		scan.close();
		
	}

}
