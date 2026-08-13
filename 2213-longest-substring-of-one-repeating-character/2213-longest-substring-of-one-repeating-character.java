class Solution {

    class Node {
        char leftChar, rightChar;
        int leftCount, rightCount;
        int max, len;

        Node(char c) {
            leftChar = rightChar = c;
            leftCount = rightCount = max = len = 1;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {

        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int index) {

        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node(a.leftChar);

        res.len = a.len + b.len;
        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.leftCount = a.leftCount;
        res.rightCount = b.rightCount;

        res.max = Math.max(a.max, b.max);

        // Can join the right part of a with left part of b
        if (a.rightChar == b.leftChar) {

            int combined = a.rightCount + b.leftCount;

            res.max = Math.max(res.max, combined);

            // Entire left segment has the same character
            if (a.leftCount == a.len) {
                res.leftCount = a.len + b.leftCount;
            }

            // Entire right segment has the same character
            if (b.rightCount == b.len) {
                res.rightCount = b.len + a.rightCount;
            }
        }

        return res;
    }
}