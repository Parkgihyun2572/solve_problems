/*
# 백준 1789번 수들의 합

# 문제
서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
# 입력
첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
# 출력
첫째 줄에 자연수 N의 최댓값을 출력한다.
# 예제 입력 1 
200
#예제 출력 1 
19
 */

package greedy;

import java.util.Scanner;

public class B1789 {
	
	public static void main(String[] args) {
		
		// 입력 받기
		Scanner scan = new Scanner(System.in);		
		long sum = scan.nextLong();
		scan.close();
		
		// 최대한 많은 서로 다른 자연수의 합으로 S를 구성하기 위해서는 작은 수부터 쌓아나가야 한다.
		long num = 0;
		int count = 0;
		while(sum >= num) { // 1부터 더해가며 그 합이 주어진 수를 넘지 않는지 확인
			num += (++count);
		}
		if(sum < num) { // 넘었다면 이전에 자연수 중에 하나를 빼면 되기에 -1
			count--;
		}
		System.out.println(count);
		
	}

}
