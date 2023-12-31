package Grind75;

import java.util.HashMap;
import java.util.Stack;

public class Week1 {

    // Two Sum
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            
            int check = target - nums[i];

            if( map.containsKey(check)){
                return new int[]{map.get(check), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return null;
    }
    
    // Valid Parentheses
     public boolean isValid(String s) {

     Stack<Character> stack = new Stack<Character>();

    for( char c : s.toCharArray()){
        if( c == '('){
            stack.push(')');
        }else if( c == '['){
            stack.push(']');
        }else if( c == '{'){
            stack.push('}');
        }else if(stack.isEmpty() || stack.pop() != c){
            return false;
        }
    }

    return stack.isEmpty();

    }

    // Best Time to Buy and Sell
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for( int i =0; i< prices.length; i++){

            min = Math.min(prices[i], min);

            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }

        return max;
    }

}
