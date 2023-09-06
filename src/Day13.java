import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    
    // Contains most water 
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;

        int area = 0;
        int result = 0;
        while ( left <= right){

            area = (Math.min( height[left], height[right]))* (right-left);
            result = Math.max(result, area);

            if ( height[left] > height[right]){
                right--;
            }else{
                left ++;
            }

        }

        return result;
    }

    // 3Sum 
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        
        for ( int i =0; i<n-2; i++ ){

            if( i !=0 && nums[i] == nums[i-1]){
                continue;
            }

            int low = i+1;
            int high = n-1;

            while ( low< high){
                int sum = nums[i] + nums[low] + nums[high];

                if ( sum == 0){
                    List<Integer> res = Arrays.asList( nums[i], nums[low], nums[high]);
                    list.add(res);
                    low++;
                    high--;
                    
                    while ( low<high && nums[low] == nums[low-1]){
                        continue;
                    }

                    while( low<high && nums[high] == nums[high+1]){
                        continue;
                    }
                }else if ( sum>0){
                    high --;
                }else{
                    low++;
                }

            }
        }

        return list;
    }
}
