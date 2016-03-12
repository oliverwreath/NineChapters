/**
 * Created by Yanliang Han on 2016/3/12.
 */
public class DynamicProgrammingSolutions {

    public static class TriangleSolutions {
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

    public static class PathSolutions {
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

        /**
         * @param n, m: positive integer (1 <= n ,m <= 100)
         * @return an integer
         */
        public int uniquePaths(int m, int n) {
            // write your code here
            if (m < 1 || n < 1) {
                return 1;
            }

            // state f[x][y] means Num of uniquePaths from 0,0
            int[][] paths = new int[m][n];

            // initialize
            paths[0][0] = 1;
            for (int x = 1; x < m; x++) {
                paths[x][0] = 1;
            }
            for (int y = 1; y < n; y++) {
                paths[0][y] = 1;
            }

            // top down
            for (int x = 1; x < m; x++) {
                for (int y = 1; y < n; y++) {
                    paths[x][y] = paths[x-1][y] + paths[x][y-1];
                }
            }

            // answer
            if (IS_TESTING) {
                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        System.out.print(paths[x][y] + " ");
                    }
                    System.out.println();
                }
            }
            return paths[m-1][n-1];
        }

        /**
         * @param n: An integer
         * @return: An integer
         */
        public int climbStairs(int n) {
            // write your code here
            if (n <= 1) {
                return 1;
            }

            // state f(n) number of ways to reach n
            int[] numOfWays = new int[n];

            // initialize
            numOfWays[0] = 1;
            numOfWays[1] = 2;

            // top Down
            for (int x = 2; x < n; x++) {
                numOfWays[x] = numOfWays[x - 1] + numOfWays[x - 2];
            }

            // answer
            return numOfWays[n-1];
        }
    }

    private static final boolean IS_TESTING = true;

    public static void main(String[] args) {
//        int[][] triangle = new int[2][];
//        triangle[0] = new int[]{0};
//        triangle[1] = new int[]{-1, 2};
//        System.out.println(new TriangleSolutions().minimumTotalTopDown(triangle));


//        int[][] grid = new int[2][];
//        grid[0] = new int[]{0, 2};
//        grid[1] = new int[]{-1, 0};
//        System.out.println(new PathSolutions().minPathSum(grid));

//        System.out.println(new PathSolutions().uniquePaths(3, 62));

        System.out.println(new PathSolutions().climbStairs(0));
        System.out.println(new PathSolutions().climbStairs(1));
        System.out.println(new PathSolutions().climbStairs(2));
        System.out.println(new PathSolutions().climbStairs(3));
        System.out.println(new PathSolutions().climbStairs(4));
    }
}
