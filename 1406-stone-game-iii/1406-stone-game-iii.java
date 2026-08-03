// class Solution {
//     public String stoneGameIII(int[] stoneValue) {
//         int[] dp = new int[stoneValue.length];
//         Arrays.fill(dp, -1);
//         int ans = helper(0, stoneValue, dp);

//         if(ans > 0){
//             return "Alice";
//         }
//         else if(ans < 0){
//             return "Bob";
//         }
//         else return "Tie";
//     }

//     int helper(int start, int[] stoneValue, int[] dp){
//         int end = stoneValue.length;
//         int maxDiff = Integer.MIN_VALUE;
//         int sum = 0;
        
//         if(start >= end) return 0; // base

//         if(dp[start] != -1) return dp[start];

//         for(int i = 0; i<3 && i+start < end; i++){
//             sum += stoneValue[i+start];

//            maxDiff = Math.max(maxDiff,sum - helper(start + i + 1, stoneValue, dp));
//         }
//         return dp[start] = maxDiff;
//     }
// }

class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int sum = 0;
            int maxDiff = Integer.MIN_VALUE;

            for (int k = 0; k < 3 && i + k < n; k++) {

                sum += stoneValue[i + k];

                maxDiff = Math.max(maxDiff,
                        sum - dp[i + k + 1]);
            }

            dp[i] = maxDiff;
        }

        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}