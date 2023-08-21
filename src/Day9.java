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

    
}
