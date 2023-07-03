package programmers;

public class Lv1_GetCenterString {
	class Solution {
	    
	    static boolean isOdd;
	    static String answer;
	    
	    public String solution(String s) {
	        
	        isOdd = judgeOdd(s);
	        answer = getAnswer(s, isOdd);
	        return answer;
	    }
	    
	    static String getAnswer(String s, boolean isOdd){
	        if(isOdd){
	            return String.valueOf(s.charAt(s.length() / 2 - 1)) + String.valueOf(s.charAt(s.length() / 2));
	        } else {
	            return String.valueOf(s.charAt(s.length() / 2));
	        }
	    }
	    
	    static boolean judgeOdd(String s){
	        if(s.length() % 2 == 0){
	            return true;
	        } else{
	            return false;
	        }
	    }
	}
}
