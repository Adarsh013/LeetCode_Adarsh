class Solution {
    public boolean predictTheWinner(int[] nums) {
        //       Start, end, p1 sum, p2 sum, p1 turn, array  
        return dfs (0, nums.length -1, 0, 0, true, nums);
    }

    boolean dfs(int left, int right, int p1Sum, int p2Sum, boolean turn, int[] nums){

        if(left > right) return p1Sum >= p2Sum;

        if(turn){
            return dfs(left+1, right, p1Sum+nums[left], p2Sum, false,nums) ||
                   dfs(left, right-1, p1Sum+nums[right], p2Sum, false,nums);
        }
        else{
            return dfs(left+1 , right, p1Sum, p2Sum+nums[left], true,nums) &&
                   dfs(left, right-1, p1Sum, p2Sum+nums[right], true,nums);
        }
    }
}