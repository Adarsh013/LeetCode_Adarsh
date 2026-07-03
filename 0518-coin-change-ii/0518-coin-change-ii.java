class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] =  new int[n][amount + 1];

        for(int i = 0; i<=amount; i++){
            if(i % coins[0] == 0) 
                dp[0][i] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int amt = 0; amt<=amount; amt++){

                int nottake = dp[i - 1][amt];
                int take = 0;

                if(coins[i] <= amt) {
                    take = dp[i][amt - coins[i]];
                }

                dp[i][amt] = take+nottake;
            }
        }
        return dp[n-1][amount];
    }       
}