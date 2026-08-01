class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;

        for(int num : nums){
            maxi = Math.max(maxi, num);
        }

        int low = 1;
        int high = maxi;

        while(low <= high){
            int mid = low + (high - low ) /2;

            if(isPossible(nums,mid,threshold)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isPossible(int[] nums, int div, int threshold){
        int res = 0;

        for(int num : nums ){
            res += Math.ceil((double)num/div);

            if(res > threshold) return false;
        }
        return true;
    }
}