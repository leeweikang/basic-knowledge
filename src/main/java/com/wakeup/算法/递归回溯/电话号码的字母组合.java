package com.wakeup.算法.递归回溯;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {

    List<String> resList = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return resList;
        }
        recall(digits.toCharArray(), 0);
        return resList;
    }

    public void recall(char[] nums, int index) {
        if (sb.length() == nums.length) {
            resList.add(sb.toString());
            return;
        }
        String s = phoneMap.get(nums[index]);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            recall(nums, index + 1);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }



}
