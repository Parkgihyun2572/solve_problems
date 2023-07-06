package programmers;

import java.util.*;

public class Lv1_DivisedNumberArray {
	class Solution {
	    
	    static List<Integer> result = new ArrayList<>();
	    static int[] answer;
	    
	    public int[] solution(int[] arr, int divisor) {
	        
	        Arrays.sort(arr);
	        for(int i : arr){
	            if(i % divisor == 0){
	                result.add(i);
	            }
	        }
	        if(result.size() == 0){
	            result.add(-1);
	        }
	        
	        answer = new int[result.size()];
	        for(int i = 0; i < answer.length; i++){
	            answer[i] = result.get(i);
	        }
	        return answer;
	    }
	}
}
