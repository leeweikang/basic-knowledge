package com.wakeup.算法;

import java.util.LinkedList;
import java.util.List;

public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstLen = firstList.length, secondLen = secondList.length;
        List<int[]> list = new LinkedList<>();
        int i = 0, j = 0, k = 0;
        while (i < firstLen && j < secondLen) {
            int[] firstTempList = firstList[i];
            int[] secondTempList = secondList[j];
            int a = firstTempList[0], b = firstTempList[1];
            int c = secondTempList[0], d = secondTempList[1];
            if (a > d) {
                j++;
            }
            else if (c > b) {
                i++;
            }
            else {
                if (b >= c && a <= d) {
                    list.add(new int[]{Math.max(a,c), Math.min(b, d)});
                    if (b > d) {
                        j++;
                    }
                    else {
                        i++;
                    }
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
