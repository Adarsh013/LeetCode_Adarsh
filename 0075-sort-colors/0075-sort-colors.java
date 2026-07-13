// dutch National Flag Algo
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }


    void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}


// // dutch National Flag Algo
// class Solution {
//     public void sortColors(int[] nums) {
//         int low = 0;
//         int mid = 0;
//         int high = nums.length - 1;

//         while(mid <= high){
//             if(nums[mid] == 0){
//                 int temp = nums[low];
//                 nums[low] = nums[mid];
//                 nums[mid] = temp;
                
//                 low++;
//                 mid++;
//             }
//             else if(nums[mid] == 1){
//                 mid++;
//             }
//             else {
//                 int temp = nums[mid];
//                 nums[mid] = nums[high];
//                 nums[high] = temp;
//                 high--;
//             }
//         }
//     }


//     // void swap(int[] nums, int start, int end){
//     //     int temp = nums[start];
//     //     nums[start] = nums[end];
//     //     nums[end] = temp;
//     // }
// }