class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }

        return solve(0, n - 1, nums, dp) >= 0;
    }

    int solve(int left, int right, int[] nums, int[][] dp) {

        if (left == right)
            return nums[left];

        if (dp[left][right] != -1)
            return dp[left][right];

        int takeLeft = nums[left] - solve(left + 1, right, nums, dp);

        int takeRight = nums[right] - solve(left, right - 1, nums, dp);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }
}