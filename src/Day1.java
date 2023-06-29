public class day1{

    // 1. Search a 2D Matrix
    public int search(int[] nums, int target) {
        
        if(nums.length==0 || nums == null ){
            return -1;
        }
        
        int rows = nums.length;
        int cols = nums[0].length;
        int low = 0;
        int high = (rows*cols) -1;

        while ( low < high){

            int mid = low + (high - low) /2;

            if (target == nums[mid/cols][mid%cols]){
                return mid;
            }
            else if( target > nums[mid/cols][mid%cols] ){
                low = mid +1;
            }else{
                high = mid;
            }
            
        }

        return -1;
    }


    // 2.Search in Rotated Sorted Array 
    public int search(int[] nums, int target) {
        
        if(nums.length==0 || nums == null ){
            return -1;
        }
        
        int low = 0;
        int high = nums.length -1;

        while ( low <= high){

            int mid = low + (high - low) /2;

            if( nums[mid] == target){
                return mid;
            }else if( nums[low]<=nums[mid]){
                if( nums[low]<=target && nums[mid]>target ){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if( nums[high]>=target && nums[mid]<target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            
        }

        return -1;
    }

}