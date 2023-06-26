package programmers;

import java.util.*;

public class Lv1_Phoneketmon {
	
	class Solution {
	    
	    static int answer;
	    static Map<Integer, Integer> phoneketmons = new HashMap<>();
	    
	    public int solution(int[] nums) {
	        makeMap(nums);
	        if(phoneketmons.keySet().size() > nums.length / 2){
	            answer = nums.length / 2;
	        } else {
	            answer = phoneketmons.keySet().size();
	        }
	        return answer;
	    }
	    
	    static void makeMap(int[] num){
	        for(int n : num){
	            if(!phoneketmons.containsKey(n)){
	                phoneketmons.put(n, 1);
	            } else {
	                phoneketmons.put(n, phoneketmons.get(n) + 1);
	            }
	        }
	    }
	}

}
