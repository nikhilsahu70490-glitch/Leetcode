import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        // Step 1: Find the min and max elements
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // If all elements are identical, the gap is 0
        if (min == max) {
            return 0;
        }
        
        int n = nums.length;
        
        // Step 2: Calculate bucket size and number of buckets
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int numBuckets = (max - min) / bucketSize + 1;
        
        int[] bucketMin = new int[numBuckets];
        int[] bucketMax = new int[numBuckets];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // Step 3: Populate the buckets
        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }
        
        // Step 4: Calculate the max gap between successive non-empty buckets
        int maxGap = 0;
        int previousMax = min; // Start with the global minimum
        
        for (int i = 0; i < numBuckets; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            // Gap is the min of current bucket minus the max of the previous bucket
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        
        return maxGap;
    }
}