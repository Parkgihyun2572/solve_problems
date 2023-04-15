/*
# 백준 1920번 수 찾기

# 문 제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

# 입 력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

# 출 력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

# 예제 입력
5
4 1 5 2 3
5
1 3 7 9 5

# 예제 출력
1
1
0
0
1
 */

package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class B1920 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 입력 받기
		int theNumberOfSearchNumbers = scan.nextInt();
		int[] searchList = new int[theNumberOfSearchNumbers];
		for (int i = 0; i < searchList.length; i++) {

			searchList[i] = scan.nextInt();

		}
		int theNumberOfKeys = scan.nextInt();
		int[] keyList = new int[theNumberOfKeys];
		for (int i = 0; i < keyList.length; i++) {

			keyList[i] = scan.nextInt();

		}

		// 이진 검색을 사용하기 위한 내림차순 정렬
		Arrays.sort(searchList);

		// 비교
		int start, end, center, result;

		for (int i = 0; i < keyList.length; i++) {
			// 새로운 키 마다 검색 공간 리셋 필요
			start = 0;
			end = searchList.length - 1;
			center = end / 2;
			result = 0;

			do {
//				System.out.println(keyList[i] + "를 " + searchList[start] + "와 " + searchList[end] +  "사이에서 찾습니다");
				if (keyList[i] == searchList[center]) {
					result = 1;
					break;
				} else {
					if (searchList[center] > keyList[i]) {
						end = center - 1;
						center = (start + end) / 2;
					} else {
						start = center + 1;
						center = (start + end) / 2;
					}
				}

			} while (start <= end);

			// key별 결과 출력
			System.out.println(result);
		}

		scan.close();

	}

}
