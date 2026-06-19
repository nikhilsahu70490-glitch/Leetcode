class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than the rightmost element,
            // the minimum must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is at mid or in the left half.
                right = mid;
            }
        }
        
        // left and right converge to the minimum element
        return nums[left];
    }
}