class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        
        int currmax = 0;
        int maxsum = nums[0];

        int currmin = 0;
        int minsum = nums[0];
        
        for(int i = 0; i<nums.length; i++){
            total += nums[i];

            // Kadance for Maximum sum
            currmax = Math.max(nums[i], nums[i] + currmax);
            maxsum = Math.max(maxsum, currmax);

            // Kadance for minimum sum
            currmin = Math.min(nums[i], nums[i] + currmin);
            minsum = Math.min(minsum, currmin);
        }

        
        if(maxsum < 0) return maxsum;

        return Math.max(maxsum, total - minsum);
    }


}
