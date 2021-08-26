package com.wakeup.算法.动态规划;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] res = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            char temp = text1.charAt(i - 1);
            for (int j = 1; j < len2 + 1; j++) {
                if (temp == text1.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }
                else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[len1][len2];
    }
}
