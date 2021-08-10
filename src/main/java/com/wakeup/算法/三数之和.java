package com.wakeup.算法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return null;
        }
        List<List<Integer>> resList = new LinkedList<>();

        int i = 0;
        Arrays.sort(nums);
        while (i < len - 2) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> tempList = new LinkedList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    resList.add(new LinkedList<>(tempList));
                    while (nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (nums[j] + nums[k] + nums[i] <= 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
            while (nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return resList;
    }
}
