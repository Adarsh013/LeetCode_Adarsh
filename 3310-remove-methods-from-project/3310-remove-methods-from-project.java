class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] edge : invocations) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        // CHANGE 1: DFS should start only from k
        dfs(k, vis, adj);

        // CHANGE 2: Check if any non-suspicious node points to a suspicious node
        for (int[] edge : invocations) {

            int u = edge[0];
            int v = edge[1];

            if (!vis[u] && vis[v]) {
                // CHANGE 3: Return all methods
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // CHANGE 4: Add only non-suspicious methods
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    void dfs(int node, boolean vis[], List<List<Integer>> adj) {
        vis[node] = true;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, vis, adj);
            }
        }
    }
}