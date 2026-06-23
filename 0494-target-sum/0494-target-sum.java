class Solution {

    // Since target can be negaitve number we cant use normal dp Array
    Map<String, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(n - 1, target, nums);
    }

    int helper(int idx, int target, int[] nums) {

        if(idx == 0) {
            int count = 0;
            if(target == nums[0]) count++;
            if(target == -nums[0]) count++;

            return count;
        }

        String key = idx + "," + target;
        if(dp.containsKey(key)) return dp.get(key);

        int positive = helper(idx - 1,target - nums[idx], nums);
        int negative = helper(idx - 1,target + nums[idx], nums);
        
        int ans = positive + negative;
        dp.put(key, ans) ;
        return ans;
    }
}