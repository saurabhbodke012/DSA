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



}
