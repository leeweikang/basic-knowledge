package com.wakeup.算法.深搜广搜;

public class 另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }

    public boolean dfs (TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }
    public boolean check (TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null && subRoot == null) {
                return true;
            }
            else {
                return false;
            }
        }
        if (root.val == subRoot.val) {
            return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        }
        else {
            return false;
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
