class Solution {
    public int longestPalindromeSubseq(String s) {
        // Reversing the String

        String s2 = "";
        for(int i = s.length() - 1; i>=0; i--){
            s2 += s.charAt(i);
        }

        int n = s.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i<=n; i++) dp[i][0] = 0;

        for(int idx1 = 1; idx1<=n; idx1++){
            for(int idx2 = 1; idx2<=m; idx2++){

                if(s.charAt(idx1 - 1) == s2.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                }
                else
                dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
            }
        }
        return dp[n][m];
    }
}