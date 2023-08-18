public class Day7 {

    // Delete and Earn
    // Approach: Convert it into a House Robber problem form by using the sum of earnings for every number. 
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = 0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max+1];
        arr[0] = 0;
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] += nums[i];   
        }

        int n = arr.length;

        if( n == 2){
            return arr[1];
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.max ( arr[1], dp[0]);

        for( int i=2; i<arr.length; i++){
            dp[i] = Math.max( dp[i-1], dp[i-2] + arr[i]);
        }

        return dp[n-1];
    }
    
}
