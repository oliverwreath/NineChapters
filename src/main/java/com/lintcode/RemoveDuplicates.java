package com.lintcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by Yanliang Han on 2016/5/23.
 */
@Slf4j
public class RemoveDuplicates {
  public static void main(String[] args) {
//        plusOneTest();
//        strStrTest();
//        searchInsertTest();
    removeDuplicatesTest();
//        removeElementTest();
  }

  public static void removeElementTest() {

    int[] A = {0, 4, 4, 0, 0, 2, 4, 4};
    int elem = 4;
    removeElementTestHelper(A, elem);
  }

  public static void removeElementTestHelper(int[] A, int elem) {
    System.out.print(Arrays.toString(A) + " > \t");
    int newLength = removeElement(A, elem);
    if (true) {
      for (int k = 0; k < newLength; k++) {
        System.out.print(A[k] + ", ");
      }
      log.debug("");
    }
    log.debug("newLength=" + newLength);
  }

  public static int removeElement(int[] A, int elem) {

    if (A == null || A.length < 1) {
      return 0;
    }

    int len = A.length;
    int resultLength = 0;
    int i = 0;
    for (int j = 0; j < len; j++) {
      if (A[j] != elem) {
        resultLength++;
        A[i++] = A[j];
      }
    }

    return resultLength;
  }

  public static void removeDuplicatesTest() {
    int[] nums = {1, 1, 1};
    removeDuplicatesTestHelper(removeDuplicates(nums), nums);
    int[] nums2 = {1, 1, 2};
    removeDuplicatesTestHelper(removeDuplicates(nums2), nums2);
    int[] nums3 = {1, 1, 2, 2};
    removeDuplicatesTestHelper(removeDuplicates(nums3), nums3);
    int[] nums4 = {1};
    removeDuplicatesTestHelper(removeDuplicates(nums4), nums4);
    int[] nums5 = {-1014, -1014, -1014, -1012, -1012, -1011, -899, -899, -899, -898};
    removeDuplicatesTestHelper(removeDuplicates(nums5), nums5);
  }

  public static void removeDuplicatesTestHelper(int uniqueLength, int[] nums) {
    System.out.print(Arrays.toString(nums) + " > \t");
    if (true) {
      for (int k = 0; k < uniqueLength; k++) {
        System.out.print(nums[k] + ", ");
      }
      log.debug("");
    }
    log.debug("res=" + uniqueLength);
  }

  public static int removeDuplicates(int[] nums) {

    if (nums == null || nums.length < 1) {
      return 0;
    }
    if (nums.length < 2) {
      return 1;
    }

    int i = 0;
    int j = 0;
    int len = nums.length;
    int resultLength = 0;
    while (j < len) {
      int k = j;
      while (j < (len - 1) && nums[j] == nums[j + 1]) {
        j++;
      }
      int diff = j - k;
      if (diff == 0) {
        nums[i++] = nums[j++];
        resultLength++;
      } else {
        nums[i++] = nums[j];
        nums[i++] = nums[j++];
        resultLength += 2;
      }
    }

    return resultLength;
  }

  public static int removeDuplicates1(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int len = nums.length;
    int resultLength = 0;
    while (j < len) {
      while (j < (len - 1) && (nums[j] == nums[j + 1])) {
        j++;
      }
      nums[i++] = nums[j++];
      resultLength++;
    }

    return resultLength;
  }

  public static void searchInsertTest() {
    int[] A = {1, 3, 5, 6};
    log.debug(String.valueOf(searchInsert(A, 5)));
    log.debug(String.valueOf(searchInsert(A, 2)));
    log.debug(String.valueOf(searchInsert(A, 7)));
    log.debug(String.valueOf(searchInsert(A, 0)));
  }

  public static int searchInsert(int[] A, int target) {

    if (A == null || A.length < 1) {
      return 0;
    }

    int len = A.length;
    int start = 0;
    int end = len - 1;
    while (start + 1 < end) {
      int mid = (end + start) / 2;
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

    return end + 1;
  }

//    public static int searchInsert(int[] A, int target) {
//    
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
//        return len;
//    }

//    public int searchInsert(int[] A, int target) {
//    
//        if (A == null || A.length < 1) {
//            return 0;
//        }
//
//        int start = 0, end = A.length - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (A[mid] >= target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (A[start] >= target) {
//            return start;
//        }
//        if (A[end] >= target) {
//            return end;
//        }
//        return end+1;
//    }

  public static void strStrTest() {
    String source = "source";
    String target = "target";
    log.debug("{}", strStr(source, target));

    source = "abcdabcdefg";
    target = "bcd";
    log.debug("{}", strStr(source, target));
  }

  public static int strStr(String source, String target) {
    //write your code here
    if (source == null || target == null || source.length() < target.length()) {
      return -1;
    }
    int len1 = source.length();
    int len2 = target.length();
    for (int i = 0; i <= len1 - len2; i++) {
      boolean isSame = true;
      for (int j = 0; j < len2; j++) {
        if (source.charAt(i + j) != target.charAt(j)) {
          isSame = false;
          break;
        }
      }
      if (isSame) {
        return i;
      }
    }

    return -1;
  }

//    public int strStr(String source, String target) {
//        //write your code here
//        if (source == null || target == null) {
//            return -1;
//        }
//        if (target.isEmpty()) {
//            return 0;
//        }
//        int len1 = source.length();
//        int len2 = target.length();
//        for (int i = 0; i < len1 - len2 + 1; i++){
//            if (source.charAt(i) == target.charAt(0)) {
//                boolean isFound = true;
//                for (int j = i + 1, k = 1; k < len2; j++, k++) {
//                    if (source.charAt(j) == target.charAt(k)) {
//
//                    } else {
//                        isFound = false;
//                    }
//                }
//                if (isFound) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

  /**
   * @param digits a number represented as an array of digits
   * @return the result
   */
  public static int[] plusOne(int[] digits) {

    if (digits == null || digits.length == 0) {
      return new int[]{};
    }

    int len = digits.length;
    int carry = 1;
    for (int i = len - 1; i >= 1; i--) {
      digits[i] += carry;
      if (digits[i] > 9) {
        digits[i] -= 10;
        carry = 1;
      } else {
        carry = 0;
      }
    }
    digits[0] += carry;
    if (digits[0] > 9) {
      digits[0] -= 10;
      carry = 1;
    } else {
      carry = 0;
    }

    if (carry == 0) {
      return digits;
    }
    int[] expandedArray = new int[len + 1];
    for (int i = len - 1; i >= 0; i--) {
      expandedArray[i + 1] = digits[i];
    }
    expandedArray[0] = 1;
    return expandedArray;
  }

  public static void plusOneTest() {
    int[] ints = {1, 3, 5};
    log.debug("input=" + Arrays.toString(ints));
    log.debug("result=" + Arrays.toString(plusOne(ints)));

    int[] ints2 = {9};
    log.debug("input=" + Arrays.toString(ints2));
    log.debug("result=" + Arrays.toString(plusOne(ints2)));

    int[] ints3 = {9, 9, 9};
    log.debug("input=" + Arrays.toString(ints3));
    log.debug("result=" + Arrays.toString(plusOne(ints3)));
  }
}
