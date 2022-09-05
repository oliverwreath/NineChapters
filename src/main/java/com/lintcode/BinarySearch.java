package com.lintcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/5/25.
 */
@Slf4j
public class BinarySearch {
  public static int totalOccurrence(int[] a, int target) {
    int[] ints = searchRange(a, target);
    if (ints[0] == -1) {
      return 0;
    } else {
      return ints[1] - ints[0] + 1;
    }
  }

  public static int[] searchRange(int[] a, int target) {
    int[] ret = new int[]{-1, -1};
    if (a == null || a.length < 1) {
      return ret;
    }

    int start = 0;
    int end = a.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (a[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (a[start] == target) {
      ret[0] = start;
    } else if (a[end] == target) {
      ret[0] = end;
    }

    start = 0;
    end = a.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (a[mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (a[end] == target) {
      ret[1] = end;
    } else if (a[start] == target) {
      ret[1] = start;
    }

    return ret;
  }

  static class ArrayReader {
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


  public static int[] findMin(int[] num) {
    if (num == null || num.length < 1) {
      return new int[]{-1, -1};
    }

    int start = 0;
    int end = num.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (num[start] < num[end]) {
        return new int[]{start, num[start]};
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
      return new int[]{start, num[start]};
    } else {
      return new int[]{end, num[end]};
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

    return Math.min(num[start], num[end]);
  }

  private static boolean ifMin(int index, int[] num) {
    if (index == 0) {
      return num[index] < num[num.length - 1];
    } else {
      return num[index] < num[index - 1];
    }
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
      return searchArray(matrix[end], target);
    } else {
      return searchArray(matrix[start], target);
    }
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

  public static int searchInsert(int[] a, int target) {
    if (a == null || a.length < 1) {
      return 0;
    }

    int len = a.length;
    int start = 0;
    int end = len - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (a[mid] >= target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (a[start] >= target) {
      return start;
    }
    if (a[end] >= target) {
      return end;
    }

    return a.length;
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
