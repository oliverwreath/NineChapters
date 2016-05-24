import java.util.Arrays;

/**
 * Created by Yanliang Han on 2016/5/23.
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 3, 5};
        System.out.println("input=" + Arrays.toString(ints));
        System.out.println("result=" + Arrays.toString(plusOne(ints)));

        int[] ints2 = {9};
        System.out.println("input=" + Arrays.toString(ints2));
        System.out.println("result=" + Arrays.toString(plusOne(ints2)));

        int[] ints3 = {9, 9, 9};
        System.out.println("input=" + Arrays.toString(ints3));
        System.out.println("result=" + Arrays.toString(plusOne(ints3)));
    }

    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public static int[] plusOne(int[] digits) {
        // Write your code here
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
}