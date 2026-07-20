class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int m = grid.length; // Row
        int n = grid[0].length; // column
        int totalLen = m*n;

        for(int i = 0; i < m; i++){
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j<n; j++){
                row.add(0);
            }

            ans.add(row);
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                int oldIdx = i * n + j;

                int newIdx = (oldIdx + k) % totalLen;    

                // COnvert 1D to 2D

                int newRow = newIdx / n;
                int newCol = newIdx % n;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}