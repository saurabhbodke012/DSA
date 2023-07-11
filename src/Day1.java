public class Day1{

    // 1. Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix == null ){
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = (rows*cols) -1;

        while ( low <= high){

            int mid = low + (high - low) /2;

            if (target == matrix[mid/cols][mid%cols]){
                return true;
            }
            else if( target > matrix[mid/cols][mid%cols] ){
                low = mid +1;
            }else{
                high = mid-1;
            }
            
        }

        return false;
    }


    // 2.Search in Rotated Sorted Array 
    public int searchArr(int[] nums, int target) {
        
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


    // 3.Search in a Sorted Array of Unknown Size
    public int search(ArrayReader reader, int target) {
        
        int low =0;
        int high = 1;

        while( reader.get(high)<target){
            low = high;
            high = 2*high;
        }

        while (low<=high){

            int mid = low + (high -low)/2;

            if( reader.get(mid) == target){
                return mid;
            }else if ( reader.get(mid)> target ){
                high = mid-1;
            }else{
                low = mid +1;
            }

        }

        return -1;
    }

}