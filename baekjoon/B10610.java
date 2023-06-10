/*
문제
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다.
미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어
30의 배수가 되는 가장 큰 수를 만들고 싶어한다.

미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

입력
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

출력
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면,
-1을 출력하라.

예제 입력 1 
30
예제 출력 1 
30
예제 입력 2 
102
예제 출력 2 
210
예제 입력 3 
2931
예제 출력 3 
-1
예제 입력 4 
80875542
예제 출력 4 
88755420

13243730324343 넣어서 3으로 나눈 수를 봤더니 
Exception in thread "main" java.lang.NumberFormatException: For input string: "74443333332210"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:668)
	at java.base/java.lang.Integer.parseInt(Integer.java:786)
	at greedy.B10610.judgeMultipleOf3(B10610.java:50)
	at greedy.B10610.main(B10610.java:79)
 */

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B10610 {
	
	static String makeStringReverse(String numStr) {
		char[] numsArr = numStr.toCharArray();
		Arrays.sort(numsArr);
		return new StringBuilder(new String(numsArr)).reverse().toString();
	}
	
	static boolean judgeMultipleOf3(String numStr) {
		char[] numsArr = numStr.toCharArray();
		
		int sum = 0;
		for (char i : numsArr) {
			int num = Character.getNumericValue(i);
			sum += num;
		}
		
		if(sum % 3 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		// 입력 받기
		Scanner scan = new Scanner(System.in);		
		String numbersString = scan.next();
		scan.close();
		
		/* 30의 배수인 최대수의 조건
		   1. 주어진 각 수 중 가장 높은 수를 제일 높은 자리수에 배치 - 오름차순 배열
		   2. 마지막 수가 0이여야 함.
		   3. 각 자리수의 합이 3의 배수여야 함.
		   공부 필요내용 : 배수 판정법, 문자열의 오름차순, 내림차순 배열법
		*/ 
		
		// 1. 문자열의 오름차순 배열
		numbersString = makeStringReverse(numbersString);
		
		// 2. 마지막 수가 0이여야 함. - 위 문자열에 0을 포함하고 있는가?
		boolean isZeroContained = numbersString.contains("0");

		// 3. 각 자리수의 합이 3의 배수인가?
		boolean isMultipleOf3 = judgeMultipleOf3(numbersString);
		
		// 2번과 3번 조건이 모두 충족하면 그 수를 출력, 아니면 -1 출력
		if(isZeroContained && isMultipleOf3) {
			System.out.println(numbersString);
		} else {
			System.out.println(-1);
		}
		
	}
}
