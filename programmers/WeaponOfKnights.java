package programmers;

import java.util.*;

public class WeaponOfKnights {
	
	class Solution {
	    
	    static int[] knights;
	    static int answer;
	    
	    public int solution(int number, int limit, int power) {
	        
	        knights = new int[number + 1];

	        answer = 0;
	        for(int i = 1; i <= number; i++){
	            if(countDivisors(i) > limit){
	                knights[i] = power;
	            } else {
	                knights[i] = countDivisors(i);
	            }
	            answer += knights[i];
	        }
	        
	        return answer;
	    }
	    
	    static int countDivisors(int num){
	        int count = 0;
	        List<Integer> divisors = new ArrayList<>();
	        
	        for(int i = 1; i <= Math.sqrt(num); i++){
	            if(num % i == 0){
	                divisors.add(i);
	                count++;
	                if(i != (num / i)){
	                    divisors.add(num / i);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	}

}
