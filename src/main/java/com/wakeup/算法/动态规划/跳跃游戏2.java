package com.wakeup.算法.动态规划;

public class 跳跃游戏2 {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int temp = 0;
        int len = nums.length;
        int i = 0;
        while (max < len - 1) {
            temp = Math.max(temp, i + nums[i]);
            if (i == max) {
                max = temp;
                step++;
            }
            i++;
        }
        return step;
    }
}
