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


    // 
    
}
