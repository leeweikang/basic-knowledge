package com.wakeup.算法.深搜广搜;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 所有可能的路径 {

    List<Integer> list = new LinkedList<>();
    List<List<Integer>> resList = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dps(graph, 0);
        return resList;
    }

    public void dps (int[][] graph, int cur) {
        if (cur == graph.length - 1) {
            int index = list.size();
            list.add(cur);
            resList.add(new LinkedList<Integer>(list));
            list.remove(index);
            return;
        }
        int size = graph[cur].length;
        int index = list.size();
        list.add(cur);
        for (int i = 0; i < size; i++) {
            int next = graph[cur][i];
            dps(graph, next);
        }
        list.remove(index);
        return;
    }

}
