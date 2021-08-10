package com.wakeup.算法;

import java.util.Arrays;

public class 逆转数组 {

    public static void main(String[] args) {
        int nums[] = {0,1};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void rotate(int[] nums, int k) {
        int p = 0, q;
        int len = nums.length;
        int count = 0;
        int temp = nums[p];
        k = k % len;
        while (p < k) {
            q = p;
            temp = nums[p];
            do {
                nums[q] = nums[(q - k + len) % len];
                q = (q - k + len) % len;
                count++;
            }while (q != p);
            nums[(k + p) % len] = temp;
            p++;
            if (count == len) {
                break;
            }
        }

    }
}
