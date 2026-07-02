class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] first = Arrays.copyOfRange(nums, 0, n - 1);
        int[] second = Arrays.copyOfRange(nums, 1, n);

        return Math.max(helper(first), helper(second));
    }

    int helper(int[] nums) {

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++) {

            int pick = nums[i];

            if(i > 1)
                pick += prev2;

            int notPick = prev;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}