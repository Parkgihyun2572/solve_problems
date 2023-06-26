package programmers;

import java.util.*;

public class FruitSeller {
	
	class Solution {
	    
	    static List<Integer> scoreList;
	    static int p, extra, answer;
	    
	    public int solution(int k, int m, int[] score) {
	        
	        scoreList = new ArrayList<>();
	        for(int i = 0; i < score.length; i++){
	            scoreList.add(score[i]);
	        }
	        scoreList.sort(Comparator.reverseOrder());
	        p = scoreList.size() / m;
	        extra = scoreList.size() - (p * m);
	        
	        if(extra > 0){
	            for(int i = 0; i < extra; i++){
	                scoreList.remove((p * m));
	            }
	        }
	        // System.out.println(scoreList);
	        
	        answer = 0;
	        for(int i = 0; i < p; i++){
	            int min = scoreList.get(i * m);
	            for(int j = 1; j < m; j++){
	                if(min > scoreList.get(i * m + j)){
	                    min = scoreList.get(i * m + j);
	                }
	            }
	            answer += min * m;
	        }
	        return answer;
	    }
	}

}
