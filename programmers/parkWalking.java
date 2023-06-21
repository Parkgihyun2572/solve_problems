package programmers;

import java.util.*;

public class parkWalking {
	
	static int [] curPos;
	static int [][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int [][] obs;
	static String [] park1 = {"SOO", "OOO", "OOO"};
	static String [] routes1 = {"E 2", "S 2", "W 1"};
	
	public static void main(String[] args) {
		
		curPos = new int [2]; // 현재 위치
		obs = new int [park1.length * (park1[0].length())][2]; // 장애물 좌표 저장 공간
		int countObs = 0;
		for(int i = 0; i < park1.length; i++) {	
			for(int j = 0; j < park1[i].length(); j++) {
				if(park1[i].charAt(j) == 'S') {	// 현재 위치 탐색
					curPos[0] = i;
					curPos[1] = j;					
				} else if(park1[i].charAt(j) == 'X') {
					obs[countObs][0] = i;
					obs[countObs++][1] = j;
				}
			}
		}
		System.out.println(Arrays.toString(obs[0]));
		
		for(int i = 0; i < routes1.length; i++) {	// 방향 지시 배열 탐색
			char direction = routes1[i].charAt(0);	// 방향 확인
			int walks = routes1[i].charAt(2); // 걸음 수 확인
			
			for(int j = 0; j < walks; j++) { // 한 지시 내에서 걸음 수 만큼 이동할 위치 확인
				int [] temp = curPos;
				if(direction == 'E') {
					temp[0] += pos[0][0];
					temp[1] += pos[0][1];
				} else if(direction == 'W') {
					temp[0] += pos[1][0];
					temp[1] += pos[1][1];
				} else if(direction == 'N') {
					temp[0] += pos[2][0];
					temp[1] += pos[2][1];
				} else if(direction == 'S'){
					temp[0] += pos[3][0];
					temp[1] += pos[3][1];
				}
				
//				for(int k = 0; )
				
			}
		}
		
		int [] answer = {};
// 		return answer;
	}
}
