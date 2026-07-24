class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> pair = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                pair.add(nums[i] ^ nums[j]);
            }
        }

         // Combine each pair XOR with every element
        for (int p : pair) {
            for (int num : nums) {
                ans.add(p ^ num);
            }
        }

        return ans.size();
    }
}