class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n];
        
        // Initialize cuts array: max cuts for a string of length i + 1 is i
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            // Odd length palindromes centered at i (e.g., "aba")
            expandAroundCenter(s, i, i, cuts);
            // Even length palindromes centered at i and i+1 (e.g., "baab")
            expandAroundCenter(s, i, i + 1, cuts);
        }
        
        return cuts[n - 1];
    }
    
    private void expandAroundCenter(String s, int l, int r, int[] cuts) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (l == 0) {
                // If the palindrome starts from the beginning, 0 cuts are needed for s[0...r]
                cuts[r] = 0;
            } else {
                // Otherwise, the cuts needed is 1 + cuts needed for the prefix before this palindrome
                cuts[r] = Math.min(cuts[r], cuts[l - 1] + 1);
            }
            l--;
            r++;
        }
    }
}