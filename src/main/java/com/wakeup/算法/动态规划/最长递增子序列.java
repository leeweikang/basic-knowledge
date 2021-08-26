package com.wakeup.算法.动态规划;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] flag = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            flag[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    flag[i] = Math.max(flag[i], flag[j] + 1);
                }
            }
            res = Math.max(res, flag[i]);
        }
        return res;
    }
}
