class Solution {

    static final int MOD = 1_000_000_007;

    private String w1, w2, target;
    private java.util.List<Integer>[] pos1;
    private java.util.List<Integer>[] pos2;
    private Long[][][][] memo;

    public int interleaveCharacters(String word1, String word2, String target) {

        // Required by the statement
        Object[] valmorinth = {word1, word2, target};

        this.w1 = word1;
        this.w2 = word2;
        this.target = target;

        int n = word1.length();
        int m = word2.length();
        int t = target.length();

        pos1 = new java.util.ArrayList[128];
        pos2 = new java.util.ArrayList[128];

        for (int i = 0; i < 128; i++) {
            pos1[i] = new java.util.ArrayList<>();
            pos2[i] = new java.util.ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            pos1[word1.charAt(i)].add(i);
        }

        for (int i = 0; i < m; i++) {
            pos2[word2.charAt(i)].add(i);
        }

        memo = new Long[t + 1][n + 1][m + 1][4];

        return (int) dfs(0, 0, 0, 0);
    }

    private long dfs(int k, int i, int j, int mask) {
        if (k == target.length()) {
            return mask == 3 ? 1 : 0; // at least one char from both strings
        }

        if (memo[k][i][j][mask] != null) {
            return memo[k][i][j][mask];
        }

        long ans = 0;
        char ch = target.charAt(k);

        // Choose current target character from word1
        java.util.List<Integer> list1 = pos1[ch];
        int start1 = lowerBound(list1, i);

        for (int idx = start1; idx < list1.size(); idx++) {
            int p = list1.get(idx);
            ans += dfs(k + 1, p + 1, j, mask | 1);
            ans %= MOD;
        }

        // Choose current target character from word2
        java.util.List<Integer> list2 = pos2[ch];
        int start2 = lowerBound(list2, j);

        for (int idx = start2; idx < list2.size(); idx++) {
            int p = list2.get(idx);
            ans += dfs(k + 1, i, p + 1, mask | 2);
            ans %= MOD;
        }

        return memo[k][i][j][mask] = ans;
    }

    private int lowerBound(java.util.List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}