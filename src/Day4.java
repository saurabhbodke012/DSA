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
    

    //
    

}
