class Solution {

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for(int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        int dp[][] = new int[m+2][m+2];
        
        //for(int i = 1; i<n; i++) dp[i][i] = 0;

        for(int i = n-1; i>=1; i--){
            for(int j = i; j<=m; j++){
                 int mini = Integer.MAX_VALUE;

                for(int k = i; k <= j; k++) {

                    int cost = (arr[j + 1] - arr[i - 1]) + dp[i][k - 1] + dp[k + 1][j];

                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][m];
    }
}