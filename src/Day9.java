import java.util.ArrayList;
import java.util.List;

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


    // Spiral Traverse
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length; 
        int cols = matrix[0].length;

        ArrayList<Integer> arr = new ArrayList<Integer>();
        int left = 0; 
        int top = 0; 
        int right = cols-1;
        int bot = rows-1;

        while(top<=bot && left<=right){
            
            for ( int i=left;i<=right; i++){
                arr.add(matrix[top][i]);           
            }
            top++;

            for(int i=top; i<=bot; i++){
                arr.add(matrix[i][right]);  
            }
            right--;
        
            if(top<=bot){
                for(int i= right; i>=left; i--){
                    arr.add(matrix[bot][i]);
                }
            }    
            bot--;

            if(left<=right){
                for(int i=bot; i>=top; i--){
                   arr.add(matrix[i][left]);
                }
            }    
            left++;

        }

        return arr;
    }
}
