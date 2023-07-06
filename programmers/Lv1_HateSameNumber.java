package programmers;

import java.util.*;

public class Lv1_HateSameNumber {
	public class Solution {
	    
	    static int[] answer;
	    static List<Integer> result = new ArrayList<>();
	    static Queue<Integer> queue = new LinkedList<>();
	    
	    public int[] solution(int []arr) {
	        
	        for(int i : arr){
	            if(queue.peek() == null){
	                queue.offer(i);
	            } else {
	                if(queue.peek() == i){
	                    continue;
	                } else {
	                    result.add(queue.poll());
	                    queue.offer(i);
	                }
	            }
	        }
	        result.add(queue.poll());
	        
	        answer = new int[result.size()];
	        for(int i = 0; i < answer.length; i++){
	            answer[i] = result.get(i);
	        }
	        return answer;
	    }
	}
}
