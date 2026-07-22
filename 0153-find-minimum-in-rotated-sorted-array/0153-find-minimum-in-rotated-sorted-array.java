class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
        

        // int s = 0;
        // int end = nums.length - 1;
        // int ans = Integer.MAX_VALUE;
        // while(s <= end){
        //     int mid = s + (end - s)/2;
        //     if(nums[s] <= nums[mid]){
        //         ans = Math.min(ans, nums[s]);
        //         s = mid + 1;
        //     }
        //     else{
        //         end = mid -1;
        //         if(ans > nums[mid])
        //             ans = nums[mid];
                
        //     }
        // }
        // return ans;
    }
}