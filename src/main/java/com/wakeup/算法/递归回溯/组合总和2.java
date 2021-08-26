package com.wakeup.算法.递归回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和2 {
    List<Integer> list = new LinkedList<>();
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recall(candidates, 0,  target, 0);
        return resList;
    }


    public void recall(int[] nums, int sum, int target,int index) {
        if (sum == target) {
            resList.add(new LinkedList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (sum > target) {
                break;
            }
            int size = list.size();
            list.add(nums[i]);
            recall(nums, sum + nums[i], target, i + 1);
            list.remove(size);
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }

        }
    }
}
