class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // dp[i][j] represents the minimum health needed *before* entering room (i, j)
        int[][] dp = new int[m][n];
        
        // Base case: Calculate health needed at the princess's room (bottom-right)
        // If dungeon[m-1][n-1] is negative, we need 1 - dungeon value.
        // If it's positive (healing), we still need at least 1 health point to survive.
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        // Fill the last column (can only move DOWN to reach the next room)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        // Fill the last row (can only move RIGHT to reach the next room)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        // Fill the rest of the DP table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // The knight will choose the optimal path: min health needed between right or down
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }
        
        // The answer is the minimum health required before entering the start room (0, 0)
        return dp[0][0];
    }
}