package programmers;

import java.util.*;

public class Lv1_2016 {
	
	class Solution {
	    
	    static int[] dates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    static int month, day;
	    static String answer;
	    
	    public String solution(int a, int b) {
	        
	        month = a;
	        day = b;
	        
	        for(int i = 0; i < month - 1; i++){
	            day += dates[i - 0];
	        }
	        int c = day % 7;
	        
	        switch(c){
	            case 1 :
	                answer = "FRI";
	                break;
	            case 2 :
	                answer = "SAT";
	                break;
	            case 3 :
	                answer = "SUN";
	                break;
	            case 4 :
	                answer = "MON";
	                break;
	            case 5 :
	                answer = "TUE";
	                break;
	            case 6 :
	                answer = "WED";
	                break;
	            case 0 :
	                answer = "THU";
	                break;
	            default :
	                break;
	        }
	        
	        return answer;
	    }
	}

}
