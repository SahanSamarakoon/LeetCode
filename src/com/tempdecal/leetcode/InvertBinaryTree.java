package com.tempdecal.leetcode;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        swapRecursively(root);
        return root;
    }

    public static void swapRecursively(TreeNode root) {
        if (root == null) return;
        TreeNode tempTreeNode = root.left;
        root.left = root.right;
        root.right = tempTreeNode;
        swapRecursively(root.left);
        swapRecursively(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;

        invertTree(treeNode4);
        preOrder(treeNode4);

    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static class TreeNode {
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
