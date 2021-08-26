package com.wakeup.算法.深搜广搜;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每一个节点的右侧节点指针 {

    public Node connect(Node root) {
        return null;
    }

    public Node fps2(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        Node start = root;
        while (start != null) {

            Node last = null;
            Node newStart = null;

            for (Node p = start; p != null; p = p.next) {

                if (p.left != null) {
                    if (newStart == null) {
                        newStart = p.left;
                    }
                    if (last != null) {
                        last.next = p.left;
                    }
                    last = p.left;

                }
                if (p.right != null) {
                    if (newStart == null) {
                        newStart = p.right;
                    }
                    if (last != null) {
                        last.next = p.right;
                    }
                    last = p.right;
                }

            }
            start = newStart;

        }
        return root;
    }



    public Node fps(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        root.next = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = new Node();
            while (size > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (size != 0) {
                    last.next = node;
                }
                last = node;
                size--;
            }
        }
        return root;
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}