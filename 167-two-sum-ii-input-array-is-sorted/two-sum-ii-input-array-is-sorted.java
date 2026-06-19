class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++; // Sum is too small, move left pointer to increase sum
            } else {
                right--; // Sum is too large, move right pointer to decrease sum
            }
        }
        
        // The problem guarantees exactly one solution, so this line is theoretically unreachable.
        return new int[]{-1, -1};
    }
}