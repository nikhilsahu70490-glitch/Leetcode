import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPointsOnLine = 1;
        
        // Iterate through each point as the base/anchor point
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int localMax = 0;
            
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                // Reduce the fraction to its irreducible form using GCD
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                // Handle signs consistently (e.g., -1/-2 should be 1/2)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    // Vertical line representation
                    dy = 1;
                }
                
                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }
            
            // Include the anchor point itself (+1)
            maxPointsOnLine = Math.max(maxPointsOnLine, localMax + 1);
        }
        
        return maxPointsOnLine;
    }
    
    // Helper function to calculate the Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}