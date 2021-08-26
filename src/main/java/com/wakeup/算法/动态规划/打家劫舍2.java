package com.wakeup.算法.动态规划;

public class 打家劫舍2 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] nums2 = new int[len - 1];
        int[] nums1 = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            nums1[i] = nums[i + 1];
            nums2[i] = nums[i];
        }
        return Math.max(dp(nums1), dp(nums2));
    }

    public int dp(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int res = b;
        int i = 2;
        while (i < len) {
            res = Math.max(a + nums[i], b);
            a = b;
            b = res;
            i++;
        }
        return res;
    }

}
