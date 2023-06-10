/*
# Baekjoon 2217번 로프

# 문 제
N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다.
각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.

하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.

각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.

# 입 력
첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.

# 출 력
첫째 줄에 답을 출력한다.

# 예제 입력
2
10
15

# 예제 출력
20
 */

/*
# 풀이
입력 받은 수를 정렬, 가장 낮은 수 * 줄의 개수 = 버틸 수 있는 무게
가장 낮은 수부터 하나씩 확인해가며 버틸 수 있는 무게의 배열을 구한 후 최댓값 확인
 */

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2217 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 입력 받기
		int numberOfLines = scan.nextInt();
		int[] maxWeightOfLines = new int[numberOfLines];
		for(int i = 0; i < numberOfLines; i++) {
			maxWeightOfLines[i] = scan.nextInt();
		}
		
		scan.close();
		
		// 내림차순 정렬
		Arrays.sort(maxWeightOfLines);
		
		// 가장 낮을 수부터 하니씩 확인
		// 처음 수 = 줄 중 가장 작은 최대 부대 * 총 줄의 개수
		int maxAllowableWeight = maxWeightOfLines[0] * numberOfLines;
		
		// 이후 하나씩 빼가며 최대값 확인
		for (int i = 1; i < maxWeightOfLines.length; i++) {
			int allowableWeight = maxWeightOfLines[i] * (numberOfLines - i);
			if(maxAllowableWeight < allowableWeight) {
				maxAllowableWeight = allowableWeight;
			}
		}
		
		// 결과 출력
		System.out.println(maxAllowableWeight);
		
	}

}
