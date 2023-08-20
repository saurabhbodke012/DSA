public class Day8 {
    
    //Minimum Cost For Tickets
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        
        for(int i =0; i<dp.length; i++){
            dp[i] = 0;
        }

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
    
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {

                i++;
            
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }
    

    //House Robber II
    public int rob(int[] nums) {
        
        if(nums == null || nums.length ==0){
            return 0;
        }

        if( nums.length == 1){
            return nums[0];
        }

        if( nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i=0; i<arr1.length; i++){
            arr1[i] = nums[i];
            arr2[i] = nums[i+1];
        }

        int rob1 = helper(arr1);
        int rob2 = helper(arr2);

        return Math.max(rob1, rob2);

    }

    public static int helper(int[] nums){
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max( dp[i-1], nums[i]+ dp[i-2]);
        }

        return dp[nums.length-1];
    }
}
