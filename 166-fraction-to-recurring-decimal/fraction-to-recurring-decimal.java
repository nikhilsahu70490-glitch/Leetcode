import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        
        // Step 1: Handle the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            res.append("-");
        }
        
        // Step 2: Convert to long to prevent overflow (e.g., -2147483648)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Step 3: Integral part (before the decimal point)
        res.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return res.toString();
        }
        
        // Step 4: Fractional part (after the decimal point)
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            // If the remainder has been seen before, a repeating loop is detected
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            
            // Record the current remainder and its position in the string
            map.put(remainder, res.length());
            
            // Perform the long division step
            remainder *= 10;
            res.append(remainder / den);
            remainder %= den;
        }
        
        return res.toString();
    }
}