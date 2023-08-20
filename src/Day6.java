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


}
