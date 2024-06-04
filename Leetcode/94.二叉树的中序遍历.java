package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

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

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                // 先左
                root = root.left;
            }
            root = stack.pop();
            // 再中
            res.add(root.val);
            // 最后右
            root = root.right;
        }
        return res;


        /*
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Morris 中序遍历。类似线索二叉树的构建
        TreeNode preDecessor = null;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }
            else {
                // 从 root 左孩子开始
                // 找到 root 左子树最右的节点
                preDecessor = root.left;
                while (preDecessor.right != root && preDecessor.right != null) {
                    preDecessor = preDecessor.right;
                }
                // 找到左子树最右的节点后，建立临时链接
                if (preDecessor.right == null) {
                    // 建立链接
                    preDecessor.right = root;
                    // 进入左子树
                    root = root.left;
                }
                // 发现了先前建立的链接，表明 root 的左子树遍历完成
                else {
                    res.add(root.val);
                    // 断开链接
                    preDecessor.right = null;
                    // 进入右子树
                    root = root.right;
                }
            }
        }
        return res;
        */
    }
    /*
    // 递归，思路简单
    void f(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        f(root.left, res);
        res.add(root.val);
        f(root.right, res);
    }
    */


}
// @lc code=end

