/*
# 예제 입력
5
R R R U D D
 */

package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Iex4_1 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int [][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}} ;
		
		// 입력받기
		int width = scan.nextInt();
		String blank = scan.nextLine();
		String movingPlan = scan.nextLine();
		movingPlan = movingPlan.replaceAll("\\s", "");		
		scan.close();
		
		// 이동하기
		int [] position = {1, 1};
		
		for(int i = 0; i < movingPlan.length(); i++) {
			int indexOfdirection = 0;
			switch(movingPlan.charAt(i)) {
				case 'R' :
					indexOfdirection = 1;
					break;
				case 'D' :
					indexOfdirection = 2;
					break;
				case 'U' :
					indexOfdirection = 3;
					break;
			}
			
			int xResult = position [0] + directions[indexOfdirection][0];
			int yResult = position [1] + directions[indexOfdirection][1];
			
			if((xResult < 1) || (xResult > width) || (yResult < 1) || (yResult > width)) {

			} else {
				position [0] = xResult;
				position [1] = yResult;
			}
			
			System.out.println(Arrays.toString(position));
		}
			
	}
	
}
