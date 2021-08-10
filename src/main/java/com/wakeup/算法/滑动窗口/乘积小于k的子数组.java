package com.wakeup.算法.滑动窗口;

public class 乘积小于k的子数组 {

    public static void main(String[] args) {
        int[] nums = {10, 2, 5, 9};
        numSubarrayProductLessThanK(nums, 100);
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, prod = 1, l = 0;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) return 0;
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }


}
