class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums.length - 1, target, nums);
    }

    int helper(int idx, int target, int[] nums) {

        if(idx == 0) {

            int count = 0;

            if(target == nums[0])
                count++;

            if(target == -nums[0])
                count++;

            return count;
        }

        int positive =
            helper(idx - 1,
                   target - nums[idx],
                   nums);

        int negative =
            helper(idx - 1,
                   target + nums[idx],
                   nums);

        return positive + negative;
    }
}