class Solution {
    public String frequencySort(String s) {

        int[] count = new int[128];

        // Count frequency
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        // Buckets: frequency -> characters
        StringBuilder[] bucket = new StringBuilder[s.length() + 1];

        for (int i = 0; i < 128; i++) {

            if (count[i] > 0) {

                if (bucket[count[i]] == null) {
                    bucket[count[i]] = new StringBuilder();
                }

                bucket[count[i]].append((char) i);
            }
        }

        // Build answer from highest frequency to lowest
        StringBuilder ans = new StringBuilder();

        for (int freq = s.length(); freq >= 1; freq--) {

            if (bucket[freq] != null) {

                for (char c : bucket[freq].toString().toCharArray()) {
                    ans.append(String.valueOf(c).repeat(freq));
                }
            }
        }

        return ans.toString();
    }
}