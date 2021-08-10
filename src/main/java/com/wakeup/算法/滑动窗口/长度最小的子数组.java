package com.wakeup.算法.滑动窗口;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 999999, l = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(i - l + 1, res);
                sum -= nums[l];
                l++;
            }
        }
        return res == 999999?0:res;
    }
}
