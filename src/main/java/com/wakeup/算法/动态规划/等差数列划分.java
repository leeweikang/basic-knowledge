package com.wakeup.算法.动态规划;

public class 等差数列划分 {

    public static void main(String[] args) {

    }

    public int numberOfArithmeticSlices(int[] nums) {
        int start = 0, end = 2, res = 0;
        int len = nums.length;
        int temp = 2;
        while (start < len - 2 && end < len) {
            if (nums[end] - nums[end - 1] == nums[start + 1] - nums[start]) {
                temp ++;
                end ++;
            }
            else {
                temp = 2;
                end ++;
                start = end - 2;
            }
            res += temp - 2;
        }
        return res;
    }

}
