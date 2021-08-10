package com.wakeup.算法;

public class 盛水最多的容器 {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int temp = (end - start) * Math.min(height[start], height[end]);
            if (temp > max) {
                max = temp;
            }
            if (height[start] > height[end]) {
                end--;
            }
            else {
                start++;
            }

        }
        return max;
    }
}
