import java.util.Arrays;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {

        int n = nums.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[][][] dp = new int[n][max + 1][max + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, 0, nums, dp);
    }

    private int solve(int index, int gcd1, int gcd2, int[] nums, int[][][] dp) {

        // Base Case
        if (index == nums.length) {
            return (gcd1 != 0 && gcd1 == gcd2) ? 1 : 0;
        }

        if (dp[index][gcd1][gcd2] != -1) {
            return dp[index][gcd1][gcd2];
        }

        // Choice 1: Put current element in first subsequence
        int takeFirst = solve(
                index + 1,
                gcd(gcd1, nums[index]),
                gcd2,
                nums,
                dp
        );

        // Choice 2: Put current element in second subsequence
        int takeSecond = solve(
                index + 1,
                gcd1,
                gcd(gcd2, nums[index]),
                nums,
                dp
        );

        // Choice 3: Ignore current element
        int skip = solve(
                index + 1,
                gcd1,
                gcd2,
                nums,
                dp
        );

        long ans = 0;
        ans = (ans + takeFirst) % MOD;
        ans = (ans + takeSecond) % MOD;
        ans = (ans + skip) % MOD;

        return dp[index][gcd1][gcd2] = (int) ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}