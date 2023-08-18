public class Day6 {
    // Coin Change 2
    public int change(int amount, int[] coins) {

        if ( coins == null || coins.length ==0){
            return 0;
        }

        int m = coins.length;
        int n = amount;  
        int dp[] = new int [n+1];
        dp[0]=1;

        for (int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                
                if( j>=coins[i-1]){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        int result = dp[n];

        return result;        
    }


    // Paint House
    public int minCost(int[][] costs) {

        if ( costs == null || costs.length == 0){
            return 0;
        }

        int n = costs.length;
        int dp[][] = new int[n][3];

        for( int i=0; i<3; i++){
            dp[n-1][i] = costs[n-1][i];
        }

        for(int j= n-2; j>=0; j--){
            dp[j][0] = costs[j][0] + Math.min(dp[j+1][1], dp[j+1][2]);
            dp[j][1] = costs[j][1] + Math.min(dp[j+1][0], dp[j+1][2]);
            dp[j][2] = costs[j][2] + Math.min(dp[j+1][0], dp[j+1][1]);
        }

        return Math.min(dp[0][0],Math.min(dp[0][1], dp[0][2]) );
        
    }

    // Minimum Falling Path Sum
    public int minFallingPathSum(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0){
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for( int i=0; i<n; i++){
            dp[n-1][i] = matrix[n-1][i];
        } 

        for( int i=n-2; i>=0; i--){
            for( int j=0; j<m; j++){
                if ( j ==0 ){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }else if(j == m-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1]));
                }
            }
        }

        int res =Integer.MAX_VALUE ;
        for(int i=0; i<n; i++){
            int check = dp[0][i];
            res = Math.min(check, res);
        }

        return res;

    }

}
