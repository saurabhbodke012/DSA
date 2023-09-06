public class Day12 {

    // Remove Duplicates from sorted array II
    public int removeDuplicates(int[] nums) {

        if ( nums == null || nums.length == 0){
            return 0;
        }

        int fast = 1;
        int slow = 1;
        int count = 1;

        for( fast = 1; fast< nums.length; fast++){

            if( nums[fast] == nums[fast-1]){
                count++;
            }else{
                count = 1;
            }

            if( count <=2){
                nums[slow] = nums[fast];
                slow++;
            }

        }
        return slow;
    }
    

    // Search in a 2D matrix II
    public boolean searchMatrix(int[][] matrix, int target) {

        if ( matrix == null || matrix.length == 0){
            return false;
        }

        int rows = 0;
        int cols = matrix[0].length -1;

        while ( rows < matrix.length && cols>=0){
            int result = matrix[rows][cols];
            if ( result == target){
                return true;
            }else if ( result > target){
                cols -- ;
            }else if ( result < target){
                rows++;
            }
        }

        return false;
    }    

    // Sort Colors
    public void sortColors(int[] nums) {
        
        int red = 0; 
        int white = 0;
        int blue = nums.length-1;

        while ( white <= blue){

            if( nums[white] == 2){
                swap (nums, white,blue);
                blue--;
            }else if ( nums[white] == 0){
                swap(nums,white,red);
                red++;
                white++;
            }else if( nums[white] == 1){
                white++;
            }

        }
    }

    private static void swap( int[] nums, int start, int end){

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
