/**
 * Created by Yanliang Han on 2016/3/12.
 */
public class DynamicProgramming {

    public static class Triangle {
        /**
         * @param triangle: a list of lists of integers.
         * @return: An integer, minimum path sum.
         */
        public int minimumTotalTopDown(int[][] triangle) {
            // write your code here
            if (triangle == null || triangle.length < 1 || triangle[0].length < 1) {
                return 0;
            }

            // state f[x][y] minimum path value from x,y to 0,0
            int m = triangle.length;
            int[][] minimumToTop = new int[m][m];

            // initialize
            minimumToTop[0][0] = triangle[0][0];
            for (int x = 1; x < m; x++) {
                minimumToTop[x][0] = triangle[x][0] + minimumToTop[x-1][0];
                minimumToTop[x][x] = triangle[x][x] + minimumToTop[x-1][x-1];
            }

            // top down
            for (int x = 1; x < m; x++) {
                for (int y = 1; y < x; y++) {
                    minimumToTop[x][y] = triangle[x][y] + Math.min(triangle[x-1][y], triangle[x-1][y-1]);
                }
            }

            // answer
            int best = Integer.MAX_VALUE;
            for (int y = 0; y < m; y++) {
                best = Math.min(best, minimumToTop[m-1][y]);
            }
            return best;
        }

        /**
         * @param triangle: a list of lists of integers.
         * @return: An integer, minimum path sum.
         */
        public int minimumTotalBottomUp(int[][] triangle) {
            // write your code here
            if (triangle == null || triangle.length < 1 || triangle[0].length < 1) {
                return 0;
            }

            // state f[x][y] minimum path value from x,y to bottom
            int m = triangle.length;
            int[][] minimumToBottom = new int[m][m];

            // initialize
            for (int x = m-1, y = 0; y < m; y++) {
                minimumToBottom[x][y] = triangle[x][y];
            }

            // bottom up
            for (int x = m - 2; x >= 0; x--) {
                for (int y = 0; y <= x; y++) {
                    minimumToBottom[x][y] = triangle[x][y] + Math.min(triangle[x+1][y], triangle[x+1][y+1]);
                }
            }

            // answer
            return minimumToBottom[0][0];
        }
    }

    public static class minPathValue {
        /**
         * @param grid: a list of lists of integers.
         * @return: An integer, minimizes the sum of all numbers along its path
         */
        public int minPathSum(int[][] grid) {
            // write your code here
            if (grid == null || grid.length < 1 || grid[0].length < 1) {
                return 0;
            }

            // state the minimum path value from 0,0 to x,y
            int M = grid.length, N = grid[0].length;
            int[][] minFromOrigin = new int[M][N];

            // initialize
            minFromOrigin[0][0] = grid[0][0];
            for (int x = 1; x < M; x++) {
                minFromOrigin[x][0] = minFromOrigin[x - 1][0] + grid[x][0];
            }
            for (int y = 1; y < N; y++) {
                minFromOrigin[0][y] = minFromOrigin[0][y - 1] + grid[0][y];
            }

            // top- down
            for (int x = 1; x < M; x++) {
                for (int y = 1; y < N; y++) {
                    minFromOrigin[x][y] = Math.min(minFromOrigin[x - 1][y], minFromOrigin[x][y - 1]) + grid[x][y];
                }
            }

            // answer
            return minFromOrigin[M-1][N-1];
        }
    }

    public static void main(String[] args) {
//        int[][] triangle = new int[2][];
//        triangle[0] = new int[]{0};
//        triangle[1] = new int[]{-1, 2};
//        System.out.println(new Triangle().minimumTotalTopDown(triangle));


        int[][] grid = new int[2][];
        grid[0] = new int[]{0, 2};
        grid[1] = new int[]{-1, 0};
        System.out.println(new minPathValue().minPathSum(grid));
    }
}
