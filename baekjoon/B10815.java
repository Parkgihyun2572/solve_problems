/*
# Baekjoon 10815 숫자 카드

# 문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

# 입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
두 숫자 카드에 같은 수가 적혀있는 경우는 없다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며,
이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다

# 출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.

# 예제 입력
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10

# 예제 출력
1 0 0 1 1 0 0 1

 */

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B10815 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 입력 받기
		int numberOfMyCards = scan.nextInt();
		int[] myDeck = new int [numberOfMyCards];
		for (int i = 0; i < myDeck.length; i++) {
			myDeck[i] = scan.nextInt();
		}
		Arrays.sort(myDeck); // 검색 대상 배열 내림차순 정렬
		
		int numberOfOppenentCards = scan.nextInt();
		int[] oppenentDeck = new int [numberOfOppenentCards];
		for (int i = 0; i < oppenentDeck.length; i++) {
			oppenentDeck[i] = scan.nextInt();
		}
		
		scan.close();
		
		// 결과값 저장 공간
		int [] compareResult = new int [numberOfOppenentCards];

		// 상대방 카드에 대해 내 카드뭉치 내에 있는지 이진탐색
		for(int i = 0; i < oppenentDeck.length; i++) {
			compareResult[i] = 0;
			int startIdx = 0;
			int endIdx = myDeck.length - 1;
			while(startIdx <= endIdx) {
				int center = (startIdx + endIdx) / 2;
				if(myDeck[center] == oppenentDeck[i]) {
					compareResult[i] = 1;
					break;
				} else if(myDeck[center] > oppenentDeck[i]) {
					endIdx = center - 1;
				} else {
					startIdx = center + 1;
				}
			}
		}
		
		for(int i = 0; i < compareResult.length; i++) {
			System.out.print(compareResult[i] + " ");
		}
		
	}

}
