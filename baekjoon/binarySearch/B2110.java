/*
# 백준 2110번 공유기 설치

문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고,
집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에,
한 집에는 공유기를 하나만 설치할 수 있고,
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서,
가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과
공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

예제 입력
5 3
1
2
8
4
9

예제 출력
3
 */

/*
이진 검색은 공유기 개수가 2보다 큰 차이만큼 실시해야함
검색 대상은 이진 검색한 인덱스를 기준으로 왼쪽의 합과 오른쪽의 합이 차이가 가장 안나는 인덱스
재귀의 영역?

 */

package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public interface B2110 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 입력 받기
		int numberOfHouses = scan.nextInt();
		int numberOfRouters = scan.nextInt();
		int [] housePositions = new int[numberOfHouses];
		for (int i = 0; i < housePositions.length; i++) {
			housePositions[i] = scan.nextInt();
		}
		scan.close();
		
		// 내림차순 정렬
		Arrays.sort(housePositions);
//		System.out.println(Arrays.toString(housePositions));
		
		int maxDistance = 0;
		
		
		if(numberOfRouters <= 2) { // 공유기가 2개면 두 집의 거리를 뺀 거리가 최대 거리
			maxDistance = (housePositions[housePositions.length - 1] - housePositions[0]);
		} else { // 2개 이상이면 이분검색으로 검색
			int distanceStartPosition = 0;
			int distanceEndPosition = housePositions.length - 1;
			int startIdx = 0;
			int endIdx = housePositions.length - 1;
//			for(int i = 1; i <= (numberOfRouters - 2); i++) {
//				
//			}
			while(startIdx < endIdx) {
				int centerIdx = (startIdx + endIdx) / 2;
				int leftSum = housePositions[centerIdx] - housePositions[distanceStartPosition];
				int rightSum = housePositions[distanceEndPosition] - housePositions[centerIdx];
				if(leftSum > rightSum) {
					maxDistance = leftSum;
				} else {
					maxDistance = rightSum;
				}
				
				if(leftSum == rightSum) {
					break;
				} else if(leftSum <= rightSum){
					startIdx = centerIdx;
				} else {
					endIdx = centerIdx;
				} 
			}
			
		}
		System.out.println(maxDistance);
		
	}

}
