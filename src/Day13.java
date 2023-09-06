public class Day13 {
    
    // Contains most water 
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;

        int area = 0;
        int result = 0;
        while ( left <= right){

            area = (Math.min( height[left], height[right]))* (right-left);
            result = Math.max(result, area);

            if ( height[left] > height[right]){
                right--;
            }else{
                left ++;
            }

        }

        return result;
    }
}
