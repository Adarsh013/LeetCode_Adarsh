class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();

        int left = 0;
        int maxLen = 0;
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            
            while(map.contains(c)){
                map.remove(s.charAt(left));
                left++;
            }

            map.add(c);
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}