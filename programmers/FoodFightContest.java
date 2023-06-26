package programmers;

import java.util.*;

public class FoodFightContest {
	
	class Solution {
	    
	    static String answer;
	    static List<String> series = new ArrayList<>();
	    
	    public String solution(int[] food) {
	        for(int i = 1; i < food.length; i++){
	            if(food[i] % 2 != 0){
	                food[i]--;
	            }
	            food[i] = food[i] / 2;
	            
	            for(int j = 0; j < food[i]; j++){
	                series.add(String.valueOf(i));
	            }
	        }
	        
	        answer = "0";
	        for(int i = series.size() - 1; i >= 0; i--){
	            answer = series.get(i) + answer + series.get(i);
	        }
	        
	        return answer;
	    }
	}

}
