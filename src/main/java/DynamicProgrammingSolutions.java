import java.util.HashSet;
import java.util.Set;

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

        /**
         * @param A: A list of integers
         * @return: The boolean answer
         */
        public boolean canJump1(int[] A) {
            // wirte your code here
            if (A == null || A.length < 1) {
                return true;
            }

            int n = A.length;
            // state f[i] means is_i_reachable
            boolean[] canJump = new boolean[n];

            // initialize
            canJump[0] = true;

            // jump right approach
            for (int i = 0; i < n-1; i++) {
                if (canJump[i]) {
                    for (int j = 1; j <= A[i] && (i + j < n); j++) {
                        canJump[i + j] = true;
                    }
                }
            }

            // answer
            return canJump[n-1];
        }

        public boolean canJump2(int[] A) {
            // wirte your code here
            if (A == null || A.length < 1) {
                return true;
            }

            int n = A.length;
            // state f[i] means is_i_reachable
            boolean[] canJump = new boolean[n];

            // initialize
            canJump[0] = true;

            // search left
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (canJump[j] && j + A[j] >= i) {
                        canJump[i] = true;
                        break;
                    }
                }
            }

            // answer
            return canJump[n-1];
        }

        public boolean canJump(int[] A) {
            // wirte your code here
            if (A == null || A.length < 1) {
                return true;
            }

            int n = A.length;
            // state f[i] means is_i_reachable

            // initialize
            int farthest = A[0];

            // jump right approach
            for (int i = 1; i < n; i++) {
                if (i <= farthest && i + A[i] > farthest) {
                    farthest = i + A[i];
                }
            }

            // answer
            return farthest >= n-1? true: false;
        }

        /**
         * @param A: A list of lists of integers
         * @return: An integer
         */
        public int jump(int[] A) {
            // wirte your code here
            if (A == null || A.length < 1) {
                return 0;
            }

            int n = A.length;
            // state f[i] means is_i_reachable
            JumpResult[] jumpResults = new JumpResult[n];

            // initialize
            jumpResults[0] = new JumpResult(true, 0);
            for (int i = 1; i < n; i++) {
                jumpResults[i] = new JumpResult();
            }

            // jump right approach
            for (int i = 0; i < n-1; i++) {
                if (jumpResults[i].canJump) {
                    for (int j = 1; j <= A[i] && (i + j < n); j++) {
                        jumpResults[i + j].canJump = true;
                        jumpResults[i + j].minJump = Math.min(jumpResults[i + j].minJump, jumpResults[i].minJump+1);
                    }
                }
            }

            if (IS_TESTING) {
                for (int i = 0; i < n-1; i++) {
                    System.out.println(jumpResults[i]);
                }
            }
            // answer
            if (jumpResults[n-1].canJump) {
                return jumpResults[n - 1].minJump;
            } else {
                return 0;
            }
        }

        private class JumpResult{
            boolean canJump = false;
            int minJump = Integer.MAX_VALUE;

            public JumpResult() {
            }

            public JumpResult(boolean canJump, int minJump) {
                this.canJump = canJump;
                this.minJump = minJump;
            }

            @Override
            public String toString() {
                return "JumpResult{" +
                        "canJump=" + canJump +
                        ", minJump=" + minJump +
                        '}';
            }
        }
    }

    private static class SubSequenceSolutions{
        /**
         * @param nums: The integer array
         * @return: The length of LIS (longest increasing subsequence)
         */
        public int longestIncreasingSubsequence(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            // state f(x) the longest from 0->x
            int[] longestBy = new int[n];

            // initialization
            for (int i = 0; i < n; i++) {
                longestBy[i] = 1;
            }

            // left to right
            for (int x = 1; x < n; x++) {
                for (int before = 0; before < x; before++) {
                    if (nums[before] <= nums[x]) {
                        longestBy[x] = Math.max(longestBy[x], longestBy[before] +1);
                    }
                }
                if (IS_TESTING) {
                    System.out.println(longestBy[x] + "_" + longestBy[x]);
                }
            }

            // answer
            int max = longestBy[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, longestBy[i]);
            }
            return max;
        }
    }

    private static class PalindromSolutions{
        /**
         * @param s a string
         * @return an integer
         */
        public int minCut(String s) {
            // write your code here

            return 0;
        }

        /**
         * @param s: A string s
         * @param dict: A dictionary of words dict
         */
        public boolean wordBreak(String s, Set<String> dict) {
            // write your code here
            if (s == null || s.length() == 0) {
                return true;
            }
            if (dict == null || dict.size() == 0) {
                return false;
            }

            int n = s.length();
            // state
            int maxLength = getMaxLength(dict);
            boolean[] f = new boolean[n+1];

            // initialize
            f[0] = true;

            // left to right approach
            for (int i = 1; i <= n; i++) {
                for (int j = (Math.max(0, i - maxLength)); j < i; j++) {
                    if (f[j] && dict.contains(s.substring(j, i))) {
                        f[i] = true;
                        break;
                    }
                }
                if (IS_TESTING) {
                    System.out.print(f[i] + " ");
                }
                System.out.println();
            }

            // answer
            return f[n];
        }

        private int getMaxLength(Set<String> dict) {
            if (dict == null || dict.size() == 0) {
                return 0;
            }

            int maxLength = Integer.MIN_VALUE;
            for (String s : dict) {
                maxLength = Math.max(maxLength, s.length());
            }

            return maxLength;
        }
    }

    private static final boolean IS_TESTING = true;

    public static void main(String[] args) {
        String s = "lintcode";
        Set<String> dict = new HashSet<String>(){{
            add("lint");
            add("code");
        }};
        System.out.println(s.substring(1, 4));
        System.out.println(new PalindromSolutions().wordBreak(s, dict));

//        int[] A = new int[]{5,4,1,2,3};
//        System.out.println(new SubSequenceSolutions().longestIncreasingSubsequence(A));
//        int[] B = new int[]{4,2,4,5,3,7};
//        System.out.println(new SubSequenceSolutions().longestIncreasingSubsequence(B));

//        给出[]，这个LIS是[1,2,3]，返回 3
//
//        给出[]，这个LIS是[4,4,5,7]，返回 4
//        int[][] triangle = new int[2][];
//        triangle[0] = new int[]{0};
//        triangle[1] = new int[]{-1, 2};
//        System.out.println(new TriangleSolutions().minimumTotalTopDown(triangle));


//        int[][] grid = new int[2][];
//        grid[0] = new int[]{0, 2};
//        grid[1] = new int[]{-1, 0};
//        System.out.println(new PathSolutions().minPathSum(grid));

//        System.out.println(new PathSolutions().uniquePaths(3, 62));

//        System.out.println(new PathSolutions().climbStairs(0));
//        System.out.println(new PathSolutions().climbStairs(1));
//        System.out.println(new PathSolutions().climbStairs(2));
//        System.out.println(new PathSolutions().climbStairs(3));
//        System.out.println(new PathSolutions().climbStairs(4));

//        int[] A = new int[]{2,3,1,1,4};
//        System.out.println(new PathSolutions().canJump(A));
//        int[] B = new int[]{3,2,1,0,4};
//        System.out.println(new PathSolutions().canJump(B));
//        int[] C = new int[]{13,52,42,21,58};
//        System.out.println(new PathSolutions().canJump(C));

//        int[] A = new int[]{2,3,1,1,4};
//        System.out.println(new PathSolutions().jump(A));
//        int[] B = new int[]{3,2,1,0,4};
//        System.out.println(new PathSolutions().jump(B));
//        int[] C = new int[]{13,52,42,21,58};
//        System.out.println(new PathSolutions().jump(C));
    }
}
