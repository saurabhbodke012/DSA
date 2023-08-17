public class Day5 {
    
    // Coin Change
    public int coinChange(int[] coins, int amount) {
        
        if( coins == null || coins.length ==0){
            return 0;
        } 

        int m = coins.length;
        int n = amount;

        int[][] dp = new int [m+1][n+1];
        dp[0][0] = 0;

        for(int i=1; i<dp[0].length;i++){
            dp[0][i] = amount+1;
        }

        for(int i =1;i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                if( j<coins[i-1]){
                    // not choose case
                    dp[i][j] = dp[i-1][j];
                }else{
                    // choose case
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j- coins[i-1]]+1);
                }

            }
        }

        int res = dp[m][n];

        if( res > amount){
            return -1;
        }

        return res;

    }


    // House Robber 
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
 
        int n = nums.length;
        int[] dp = new int[n];
 
         if( n == 1){
             return nums[0];
         }
 
 
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
 
        for( int i=2; i<nums.length; i++){
 
            dp[i] = Math.max(dp[i-1], nums[i]+ dp[i-2] );
 
        }
 
        int res = dp[n-1];
        return res;
     
     }

}
