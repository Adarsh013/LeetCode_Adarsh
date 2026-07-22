/*
class Solution {
    public int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int lb = nums.length - 1;

        while(start <= end){
            int mid = start+(end - start)/ 2;
            if (nums[mid] >= x){
                lb = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
                lb = start;
            }
        }
        return lb;
    }

    public int upperBound(int[] nums, int target) {
         int start = 0;
        int end = nums.length - 1;
        int ub = nums.length ;
        while(start <= end){
            int mid = start+(end - start) / 2;
            if(nums[mid]> target){
                ub = mid;
                end  = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ub;
    }

    public int[] searchRange(int[] nums, int target) {
       if (nums.length == 0) return new int[]{-1, -1}; // handle empty array

        int lowerB = lowerBound(nums, target);

        // To handle a situation when target is not in array
        if (lowerB == nums.length || nums[lowerB] != target)
            return new int[]{-1, -1};

        return new int[]{lowerB, upperBound(nums, target) - 1};
    }
}
*/


class Solution {
    public int firstOcc(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int first = -1;

        while(start <= end){
            int mid = start+(end - start)/ 2;
            if (nums[mid] == target){
                first = mid;
                end = mid - 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return first;
    }

    public int lastOcc(int[] nums, int target) {
         int start = 0;
        int end = nums.length - 1;
        int last = -1;
       while(start <= end){
            int mid = start+(end - start)/ 2;
            if (nums[mid] == target){
                last = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
       int first = firstOcc(nums, target);
       if(first == -1) return new int[]{-1, -1};
       return new int[]{first, lastOcc(nums,target)};
    }
}