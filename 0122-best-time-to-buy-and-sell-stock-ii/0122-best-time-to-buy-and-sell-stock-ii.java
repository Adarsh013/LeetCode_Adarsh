class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int[][] dp = new int[n+1][2]; // changing state index and buy (either 0 OR 1)

        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        return helper(0, 1, prices, profit, dp);
    }

    private int helper(int idx, int buy, int[] prices, int profit, int[][] dp){
        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1, 0, prices, profit, dp), 
                            0 + helper(idx+1, 1, prices, profit, dp));
        }
        else{
           profit = Math.max(prices[idx] + helper(idx+1, 1, prices, profit, dp),
                             0 + helper(idx+1, 0, prices, profit, dp));
        }
        return dp[idx][buy] = profit;
    }
}