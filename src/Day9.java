public class Day9 {
    // Product of itself
    public int[] productExceptSelf(int[] nums) {
        
        int[] arr = new int[nums.length];
        arr[0] = 1;
        int runningSum = 1;
        for(int i=1; i<nums.length; i++){
            arr[i] = arr[i-1]*nums[i-1];
        } 
        
        arr[nums.length - 1] = runningSum*arr[nums.length-1];

        for(int i = nums.length-2; i>=0; i--){
            runningSum *= nums[i+1]; 
            arr[i] = runningSum * arr[i];
        }

        return arr;
    }

    // Diagonal Traverse
    public int[] findDiagonalOrder(int[][] mat) {
        
        int rows = mat.length; 
        int cols = mat[0].length;
        int[] arr = new int[rows*cols];
        int index =0;
        int r = 0;
        int c = 0;
        boolean flag = true;
        while ( index < arr.length){
            arr[index] = mat[r][c];
            index++;

            // traverse UP 
            if( flag ){
                if ( c == cols -1){
                    r++;
                    flag = false;
                }else if( r == 0){
                    c++;
                    flag = false;
                }else{
                    r--;
                    c++;
                }
            }else if( flag == false){
                if ( r == rows -1){
                    c++;
                    flag = true;
                }else if( c == 0){
                    r++;
                    flag = true;
                }else{
                    r++;
                    c--;
                }
            }

        }

        return arr;

    }
}
