package com.wakeup.算法.递归回溯;

import java.util.LinkedList;
import java.util.List;

public class 子集 {

    List<Integer> list = new LinkedList<>();
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
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
        }
    }

}
