package com.wakeup.算法.动态规划;

import java.util.List;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] flag = new boolean[len + 1];
        flag[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i)) ){
                    flag[i + 1] = true;
                }
            }
        }
        return flag[len - 1];
    }
}
