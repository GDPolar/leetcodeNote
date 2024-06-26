package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 *
 * https://leetcode.cn/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (79.51%)
 * Likes:    1525
 * Dislikes: 0
 * Total Accepted:    628K
 * Total Submissions: 789.9K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */

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
    public TreeNode invertTree(TreeNode root) {
        // 先序遍历
        if (null == root) {
            return root;
        }
        TreeNode res = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || null != root) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 此时，原来的 “右” 变成了 “左”，因此，将原先序遍历代码的 root = root.right 改写
            root = root.left;
        }
        
        return res;

        /*
        // 递归，思路简单
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
        */
    }

}
// @lc code=end

