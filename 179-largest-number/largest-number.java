import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integers to Strings
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: Compare concatenated combinations
        // If s1 + s2 > s2 + s1, s1 should come before s2
        Arrays.sort(asStrs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Descending order
            }
        });

        // Edge Case: If the largest number after sorting is "0", 
        // the entire result is just "0" (e.g., nums = [0, 0])
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build the final largest number string
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}