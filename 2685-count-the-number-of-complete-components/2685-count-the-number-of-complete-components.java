import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {

                int[] info = new int[2]; // info[0] = vertices, info[1] = sum of degrees

                dfs(i, adj, vis, info);

                int vertices = info[0];
                int edgesCount = info[1] / 2; // undirected graph

                if (edgesCount == vertices * (vertices - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] info) {

        vis[node] = true;
        info[0]++;                       // count vertex
        info[1] += adj.get(node).size(); // add degree

        for (int next : adj.get(node)) {
            if (!vis[next]) {
                dfs(next, adj, vis, info);
            }
        }
    }
}