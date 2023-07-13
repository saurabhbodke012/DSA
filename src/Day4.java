import java.util.HashMap;
import java.util.HashSet;

public class Day4 {

    // Longest Palindrome
    public int longestPalindrome(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int count =0;
        for (int i=0; i< s.length(); i++){

            char schar = s.charAt(i);

            if( set.contains(schar)){
                count +=2;
                set.remove(schar);
            }else{
                set.add(schar);
            }

        }

        if( !(set.isEmpty())){
            count = count +1;
        }

        return count;

    }
    

    //Contiguous Array
     public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int arrSum = 0;
        int result =0;


        for (int i=0;i<nums.length; i++){

            if(nums[i] == 0){
                arrSum--;
            }else{
                arrSum++;
            }


            if( map.containsKey(arrSum)){
                result = Math.max(result, i - map.get(arrSum));
            }else{
                map.put(arrSum, i);
            }

        }

        return result;
        
    }

}
