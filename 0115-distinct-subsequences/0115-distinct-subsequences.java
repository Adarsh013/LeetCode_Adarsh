class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();

        int [][] dp = new int[i+1][j+1];
        for(int val[] : dp){
            Arrays.fill(val, -1);
        }

        return helper(i-1, j-1, s, t, dp);
    }

    private int helper(int i, int j, String s, String t, int[][] dp){
        // Base cases

        if(j < 0) return 1; // if all the character of string t got matched
        if(i < 0) return 0; // if there's still remaining character and i went to -ve idx

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper(i - 1, j-1, s, t, dp) + helper(i - 1, j, s, t, dp);
        }
        return dp[i][j] = helper(i - 1, j, s, t, dp);
    }
}