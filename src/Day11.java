public class Day11 {

    // Game of Life
    public void gameOfLife(int[][] board) {
        int n = board.length; 
        int m = board[0].length;

        if ( board == null || n == 0){
            return;
        }

        for( int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int alive = countAlive(board, i, j);
                if( board[i][j] == 1 && (alive<2 || alive>3) ){
                    board[i][j] = 3;
                }else if(board[i][j] == 0 && alive == 3){
                    board[i][j] = 2;
                }
            }
        }

        for( int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if( board[i][j] == 3){
                    board[i][j] = 0;
                }else if( board[i][j] == 2){
                    board[i][j] = 1;
                }

            }
        }
    }

    private int countAlive(int[][] board, int i, int j){
        int result =0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        
        for( int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length&& (board[nr][nc] == 1 || board[nr][nc] == 3)){
                result++;
            }
        }
        return result;

    }


    // Merge Sorted Arrays
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int ptr1 = m-1;
        int ptr2 = n-1;
        int ptr3 = (m+n)-1;


        while ( ptr1 >=0 && ptr2 >=0){

            if( nums1[ptr1] > nums2[ptr2]){
                nums1[ptr3] = nums1[ptr1];
                ptr1--;
            }else{
                nums1[ptr3] = nums2[ptr2];
                ptr2--;
            }
            ptr3--;
        }

        while (ptr2 >=0){
            nums1[ptr3] = nums2[ptr2];
            ptr2--;
            ptr3--;
        }

    }
    
}
