import java.util.ArrayList;
import java.util.List;

public class Day10 {

    // Find Disappeared Numbers
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length; 
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
        
            int check = Math.abs(nums[i-1])-1;  
            if (nums[check] > 0){
                nums[check] *= -1;        
            }
        }

        for(int i=1; i<=n; i++){

            if(nums[i-1] > 0){
                list.add(i);
            }

        }

        return list;
        
    }
    
}
