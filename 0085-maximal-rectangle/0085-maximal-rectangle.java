class Solution {

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];

        int maxArea = 0;

        for(int row = 0; row < n; row++) {

            for(int col = 0; col < m; col++) {

                if(matrix[row][col] == '1')
                    heights[col]++;
                else
                    heights[col] = 0;
            }

            maxArea = Math.max( maxArea, largestRectangleArea(heights) );
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i <= n; i++) {

            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];

                int rightSmall = i;

                int leftSmall = st.isEmpty() ? -1 : st.peek();

                int width = rightSmall - leftSmall - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}