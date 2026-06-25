class Solution {
    public int minDistance(String word1, String word2) {
        int L = lcs(word1, word2);

        return word1.length() + word2.length() - 2 * L;
    }

    private int lcs(String s1, String s2) {
        // LCS -> Longest common subsequence
        int idx1 = s1.length();
        int idx2 = s2.length();
        
        
        int[][] dp = new int[idx1 + 1][idx2 + 1];
        
        // Base case
        for(int i = 0; i <= idx1; i++) dp[i][0] = 0;
        for(int j = 0; j <= idx2; j++) dp[0][j] = 0;
        
        for(int i = 1; i<=idx1; i++){
            for(int j = 1; j<=idx2; j++){
                // Match
                if(s1.charAt(i - 1) == s2.charAt(j - 1) ) {
                    dp[i][j] =  1 + dp[i - 1][j - 1];
                }
                
                // Not match
                else{
                    dp[i][j] =  Math.max( dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[idx1][idx2];
    }
}