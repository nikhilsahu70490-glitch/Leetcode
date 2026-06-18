class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Cycle sort / Place each number in its correct position
        for (int i = 0; i < n; i++) {
            // Keep swapping until the current element is in its correct place,
            // or it is out of bounds [1, n], or it is a duplicate.
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        // Step 2: Find the first mismatch
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If 1 to n are all present, the missing one is n + 1
        return n + 1;
    }
}