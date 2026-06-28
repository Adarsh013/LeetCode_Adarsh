class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        return helper(0, -1, nums, dp);
    }

    private int helper(int idx, int prevIdx, int[] nums, int[][] dp){
        
        if(idx == nums.length) return 0;

        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];

        int notTake = 0 + helper(idx+1, prevIdx, nums, dp);
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx] )
            take = 1 + helper(idx + 1, idx, nums, dp);

        // Here prevIdx + 1 because we were sending prevIdx as -1 and dp is filled with -1 so we are
        //   just shifting one value up of prevIdx. ie -> -1 hai to 0, 0 hai to 1 like that
        return dp[idx][prevIdx + 1] = Math.max(notTake, take);
    }
}