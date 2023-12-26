package com.tempdecal.leetcode;

public class MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        int max = 0;
        return traverseDepth(root,max,0);
    }

    public static int traverseDepth(TreeNode root, int max, int currentDepth) {
        if (root == null) return max;
        currentDepth++;
        if (max < currentDepth) max=currentDepth;
        max = traverseDepth(root.left, max, currentDepth);
        max = traverseDepth(root.right, max, currentDepth);
        return max;
    }
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode6;

        System.out.println(maxDepth(treeNode4));

    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
