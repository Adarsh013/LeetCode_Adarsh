class Solution {
    public int maxProfit(int[] prices) {

        int[] ahead = new int[2];
        int[] curr = new int[2];

        for(int idx = prices.length - 1; idx >= 0; idx--) {

            curr[1] = Math.max(
                -prices[idx] + ahead[0],
                ahead[1]
            );

            curr[0] = Math.max(
                prices[idx] + ahead[1],
                ahead[0]
            );

            ahead = curr.clone();
        }

        return ahead[1];
    }
}