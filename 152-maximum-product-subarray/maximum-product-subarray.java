class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // If the current element is negative, swap maxSoFar and minSoFar
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            
            // Choose the maximum/minimum between the current element alone 
            // or accumulating it into the existing subarray product
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);
            
            // Keep track of the overall global maximum product seen so far
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}