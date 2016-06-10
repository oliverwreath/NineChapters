import java.util.Arrays;

/**
 * Created by Yanliang Han on 2016/5/25.
 */
public class BinarySearch {
    public static void main(String[] args) {
//        searchInsertTest();
//        searchMatrixTest();
//        binarySearchTest();
//        findMinTest();
//        testSearchBigSortedArray();
        testSearchRange();
    }

    public static void testSearchRange() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] A, int target) {
        int[] ret = new int[]{-1, -1};
        if (A == null || A.length < 1) {
            return ret;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            ret[0] = start;
        } else if (A[end] == target) {
            ret[0] = end;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            ret[1] = end;
        } else if (A[start] == target) {
            ret[1] = start;
        }

        return ret;
    }

    public static void testSearchBigSortedArray() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + searchBigSortedArray(new ArrayReader(), i));
        }
    }

    private static class ArrayReader {
        private int[] innerArray = new int[]{1, 3, 6, 9, 21};

        public int get(int i) {
            if (i >= 0 && i < innerArray.length) {
                return innerArray[i];
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static int searchBigSortedArray(ArrayReader reader, int target) {
        int ret = -1;

        if (reader.get(0) == target) {
            return 0;
        }
        int start = 1;
        int end = 8;
        while (reader.get(end) != Integer.MAX_VALUE && (reader.get(end) < target)) {
            start = end;
            end = end * 2;
        }

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }

        return ret;
    }

    public static void findMinTest() {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(ints));
        int[] ints2 = {4, 5, 6, -1, 0, 1, 2};
        System.out.println(findMin(ints2));
        int[] ints3 = {4, 5, -2, -1, 0, 1, 2};
        System.out.println(findMin(ints3));
        int[] ints4 = {999, 999, 1000, 1000, 10000, 0, 999, 999, 999};
        System.out.println(findMin(ints4));
    }

    public static int findMin(int[] num) {
        if (num == null || num.length < 1) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (num[start] < num[end]) {
                return start * 1000000 + num[start];
            } else {
                if (num[mid] == num[end]) {
                    start = mid;
                } else if (num[mid] < num[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
//            } else if (num[start] > num[end]){
//                if (num[mid] <= num[end]) {
//                    end = mid;
//                } else {
//                    start = mid;
//                }
//            } else {
//                // ==
//                if (num[mid] < num[end]) {
//                    end = mid;
//                } else if (num[mid] > num[end]) {
//                    start = mid;
//                } else {
//
//                }
//            }
        }

        if (num[start] < num[end]) {
            return start * 1000000 + num[start];
        } else {
            return end * 1000000 + num[end];
        }
    }

    public static int findMin1(int[] num) {
        if (num == null || num.length < 1) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (num[start] < num[end]) {
                return num[start];
            } else {
                if (num[mid] < num[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }

    private static boolean ifMin(int index, int[] num) {
        if (index == 0) {
            return num[index] < num[num.length - 1];
        } else {
            return num[index] < num[index - 1];
        }
    }

    public static void binarySearchTest() {
        int[] ints = {1, 2, 3, 3, 4, 5, 10};
        for (int i = 1; i < 11; i++) {
            System.out.println(binarySearch(ints, i));
        }
        int[] ints2 = {1, 3, 5, 7};
        System.out.println(binarySearch(ints2, 3));
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static void searchMatrixTest() {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        return -1;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid][0] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end][0] <= target) {
            boolean b = searchArray(matrix[end], target);
            if (b) {
                return true;
            }
        } else {
            boolean b = searchArray(matrix[start], target);
            if (b) {
                return true;
            }
        }

        return false;
    }

    public static boolean searchArray(int[] array, int target) {
        if (array == null || array.length < 1) {
            return false;
        }

        int n = array.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (array[start] == target) {
            return true;
        }
        if (array[end] == target) {
            return true;
        }

        return false;
    }

//    public static boolean searchArray(int[] array, int target) {
//        if (array == null || array.length < 1) {
//            return false;
//        }
//
//        int n = array.length;
//        for (int j = 0; j < n; j++) {
//            if (target == array[j]) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void searchInsertTest() {
        int[] A = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(A, target));
        target = 2;
        System.out.println(searchInsert(A, target));
        target = 7;
        System.out.println(searchInsert(A, target));
        target = 0;
        System.out.println(searchInsert(A, target));
    }

    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length < 1) {
            return 0;
        }

        int len = A.length;
        int start = 0;
        int end = len - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }

        return A.length;
    }

//    public static int searchInsert(int[] A, int target) {
//        if (A == null || A.length < 1) {
//            return 0;
//        }
//
//        int len = A.length;
//        for (int i = 0; i < len; i++) {
//            if (A[i] >= target) {
//                return i;
//            }
//        }
//
//        return A.length;
//    }
}
