package com.wakeup.算法.滑动窗口;

import java.util.*;

public class 找到字符串中的所有字母异位词 {
    public static void main(String[] args) {
        findAnagrams("abcdadb", "ad");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length(),n = p.length();
        List<Integer> list = new ArrayList<>();
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(char ch : p.toCharArray()) pCnt[ch - 'a'] ++;
        int left = 0,right = 0;
        while(right < m){
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight] ++;
            // 保证只要出现不对，就将左指针向后移
            while(sCnt[curRight] > pCnt[curRight]){
                sCnt[s.charAt(left) - 'a'] --;
                left ++;
            }
            // 这个判断代表两个条件：1.在sCnt中的s子串没有与pCnt冲突的。2.两者长度相等。
            if(right - left + 1 == n) list.add(left);
            right ++;
        }
        return list;
    }
}
