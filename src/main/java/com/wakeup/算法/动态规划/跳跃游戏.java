package com.wakeup.算法.动态规划;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        return dp(nums);
    }
    public boolean dp(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if (nums[i] >= end - i) {
                end = i;
            }
        }
        return end == 0;
    }
}
