package com.wakeup.算法.递归回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列2 {

    List<Integer> list = new LinkedList<>();
    List<List<Integer>> resList = new LinkedList<>();

    public void recall(int[] nums, int[] flag) {
        if (list.size() == nums.length) {
            resList.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 1) {
                continue;
            }
            int size = list.size();
            list.add(nums[i]);
            flag[i] = 1;
            recall(nums,  flag);
            list.remove(size );
            flag[i] = 0;
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        recall(nums, flag);
        return resList;
    }
}
