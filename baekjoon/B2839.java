/*
# Baekjoon 2839번 설탕배달

# 문 제
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

# 입 력
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

# 출 력
상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

# 예제 입력
18

# 예제 출력
4
 */

package baekjoon;

import java.util.Scanner;

public class B2839 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 입력 받기
		int amountOfSuger = scan.nextInt();
		
		// 변수 정리
		int totalBags = 0;
		int bags3kg = 0;
		int bags5kg = (amountOfSuger / 5);
		int surplus = (amountOfSuger % 5);
		
		// 5로 나눈 나머지의 케이스를 나누어 정리
		switch(surplus) {
		case 0:
			totalBags = bags5kg;
			break;
		case 3:
			bags3kg = 1;
			totalBags = bags5kg + bags3kg;
			break;
		case 1:
			if(bags5kg >= 1) {
				bags5kg--;
				bags3kg += 2;
				totalBags = bags5kg + bags3kg;
			} else {
				totalBags = -1;
			}
			break;
		case 4:
			if(bags5kg >= 1) {
				bags5kg--;
				bags3kg += 3;
				totalBags = bags5kg + bags3kg;
			} else {
				totalBags = -1;
			}
			break;
		case 2:
			if(bags5kg >= 2) {
				bags5kg -= 2;
				bags3kg += 4;
				totalBags = bags5kg + bags3kg;
			} else {
				totalBags = -1;
			}
			break;
		}

		System.out.println(totalBags);
		
		scan.close();
		
	}

}
