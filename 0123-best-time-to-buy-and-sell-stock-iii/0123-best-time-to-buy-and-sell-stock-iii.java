// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2];
        
//         for(int idx = n -1; idx>0; idx--){
//             for (int buy = 0; buy<=1; buy++){

//                 if(buy == 1){
//                     dp[idx][buy] = Math.max(-prices[idx] + dp[idx+1][0], 0 + dp[idx+1][1]);
//                 }
//                 else{
//                     dp[idx][buy] = Math.max(prices[idx] + dp[idx+1][1], 0 + dp[idx+1][0]);
//                 }
//             }
//         }
//         return dp[0][1];
//     }
// }
class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][3];

        for(int[][] mat : dp)
            for(int[] row : mat)
                Arrays.fill(row, -1);

        return helper(0, 1, prices, 2, dp);
    }

    private int helper(int idx,
                       int buy,
                       int[] prices,
                       int cap,
                       int[][][] dp) {

        if(cap == 0) return 0;

        if(idx == prices.length) return 0;

        if(dp[idx][buy][cap] != -1)
            return dp[idx][buy][cap];

        int profit;

        if(buy == 1) {

            profit = Math.max(
                -prices[idx] + helper(idx + 1, 0, prices, cap, dp),
                helper(idx + 1, 1, prices, cap, dp)
            );

        } else {

            profit = Math.max(
                prices[idx] + helper(idx + 1, 1, prices, cap - 1, dp),
                helper(idx + 1, 0, prices, cap, dp)
            );
        }

        return dp[idx][buy][cap] = profit;
    }
}