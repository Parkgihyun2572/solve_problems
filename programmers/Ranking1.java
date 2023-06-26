package programmers;

import java.util.*;

public class Ranking1 {
	
	class Solution {
	    
	    static int[] answer;
	    static List<Integer> ranking = new ArrayList<>();
	    static int min;
	    
	    public int[] solution(int k, int[] score) {
	        
	        answer = new int[score.length];
	        
	        for(int i = 0; i < score.length; i++){
	            ranking.add(score[i]);
	            ranking.sort(Comparator.reverseOrder());
	            if(ranking.size() > k){
	                ranking.remove(ranking.size() - 1);
	            }
	            answer[i] = ranking.get(ranking.size() - 1);
	            // System.out.println(ranking);
	        }
	        
	        return answer;
	    }
	}

}
