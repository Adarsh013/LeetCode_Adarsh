class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        for(int i = s.length() - 1; i>=0; i--){
            s2 += s.charAt(i);
        }

        int n = s.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        return helper(n - 1, m-1, s, s2, dp);
    }

    int helper(int idx1, int idx2, String s, String s2, int[][] dp){
        if(idx1 < 0 || idx2 < 0) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + helper(idx1 - 1, idx2 - 1, s, s2, dp);
        }
        
        return dp[idx1][idx2] = 
            Math.max(helper(idx1 - 1, idx2, s, s2,dp), helper(idx1, idx2 - 1, s, s2,dp));        
    }
}