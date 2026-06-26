class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        return helper(n-1, m-1, word1, word2, dp);
    }

    private int helper(int i, int j, String word1, String word2, int[][] dp){
        // Base cases

        // word2 is exhausted -> We must delete all remaining characters of word1.
        if(j < 0) return i+1;

        /// word1 is exhausted -> We must insert all remaining characters of word2.
        if(i < 0) return j+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = 0 + helper(i - 1, j - 1, word1, word2, dp);
        
        return dp[i][j] = Math.min(1 + helper(i, j-1, word1, word2, dp), // Insert
            Math.min(1 + helper(i - 1, j, word1, word2, dp), // Delete
                     1 + helper(i - 1, j - 1, word1, word2, dp))); // Replace
    }
}