public class Day2 {

    // Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0 ){
            return new int[]{-1,-1};
        } 

        if( nums[0] > target || nums[nums.length-1] < target){
            return new int[]{-1,-1};
        }

        int first = searchFirst(nums,target);

        if (first == -1){

            return new int[]{-1,-1};
        }
        int last = searchLast(nums, first,target);

        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target){

        int low = 0;
        int high = nums.length -1;

        while( low <= high){

            int mid = low + (high-low)/2;

            if( nums[mid] == target ){
                if(  mid == 0 || nums[mid] > nums[mid-1]  ){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if ( nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }

    public int searchLast(int[] nums, int first ,int target){

        int low = first;
        int high = nums.length -1;

        while( low <= high){

            int mid = low + (high-low)/2;

            if( nums[mid] == target ){
                if( mid == nums.length-1 || nums[mid] < nums[mid+1] ){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if ( nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }
    

    // Find Peak Element
    public int findPeakElement(int[] nums) {
        
        if ( nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length -1;

        while (low <=high){
            
            int mid = low + (high - low)/2;

            if(( mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                    return mid;
            }else if (mid>0 && nums[mid] < nums[mid-1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }
}
