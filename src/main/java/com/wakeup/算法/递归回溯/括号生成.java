package com.wakeup.算法.递归回溯;

import java.util.LinkedList;
import java.util.List;

public class 括号生成 {

    List<String> resList = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return resList;
        }
        recall(n, 1, 1);
        return resList;
    }

    public void recall(int n, int index1, int index2) {
        if (sb.length() == 2 * n) {
            resList.add(sb.toString());
            return;
        }
        if (index1 <= n) {
            sb.append("(");
            recall(n, index1 + 1, index2);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        if (index2 < index1) {
            sb.append(")");
            recall(n, index1 , index2 + 1);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }

}
