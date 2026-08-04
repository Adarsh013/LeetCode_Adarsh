class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        boolean contains[] = new boolean[101];

        for(int i = 0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
            contains[nums[i]] = true;
        }

        for(int i = mini; i<=maxi; i++){
            if(!contains[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}