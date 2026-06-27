class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for(int idx = n - 1; idx >= 0; idx--) {

            dp[idx][1] = Math.max(
                -prices[idx] + dp[idx + 1][0], // buy
                dp[idx + 1][1]                 // skip
            );

            dp[idx][0] = Math.max(
                prices[idx] + dp[idx + 1][1],  // sell
                dp[idx + 1][0]                 // skip
            );
        }

        return dp[0][1];
    }
}