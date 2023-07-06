package programmers;

public class Lv1_SumOfTwoInt {
	class Solution {
	    
	    static int start, end;
	    static long answer;
	    
	    public long solution(int a, int b) {
	        
	        if(a < b){
	            start = a;
	            end = b;
	        } else {
	            start = b;
	            end = a;
	        }
	        
	        answer = 0;
	        for(int i = start; i <= end; i++){
	            answer += i;   
	        }
	        return answer;
	    }
	}
}
