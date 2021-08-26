package com.wakeup.算法.递归回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集2 {

    List<Integer> list = new LinkedList<>();
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recall(nums, 0);
        return resList;
    }

    public void recall(int[] nums, int index) {
        resList.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {

            int size = list.size();
            list.add(nums[i]);
            recall(nums, i + 1);
            list.remove(size );
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
