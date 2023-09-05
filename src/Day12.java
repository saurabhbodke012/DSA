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
}
