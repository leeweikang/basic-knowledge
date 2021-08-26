package com.wakeup.算法.动态规划;

/**
 * 可以用二维数组存，动态规划
 * 但是空间复杂度太高
 * 所以用中心扩散
 */
public class 最长回文串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i , i + 1);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                start = i - (len - 1) / 2 ;
                end = start + len;
            }
        }
        return s.substring(start, end);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }
}
