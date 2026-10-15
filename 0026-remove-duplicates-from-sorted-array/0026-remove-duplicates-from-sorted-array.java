class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) { // Whenever it is true that means a element
                nums[j + 1] = nums[i]; // Shifting towards left from right
                j++;
            }
        }
        return j + 1;
    }
}