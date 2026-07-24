class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if ( n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int start = 1;
        int end = nums.length - 2;
        //int ans = 0; 
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid +1 ])
                return nums[mid];

            if (mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid + 1] == nums[mid]){
                start = mid + 1;  // Eliminate left half
            }
            else{
                end = mid - 1;  // eliminate right half
            }   
            
        }
        return -1;
    }
}