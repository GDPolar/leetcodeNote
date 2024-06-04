package Leetcode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (58.77%)
 * Likes:    871
 * Dislikes: 0
 * Total Accepted:    368.7K
 * Total Submissions: 627K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
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
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int direction = 1;
        while (!q.isEmpty()) {
            int currLevelSize = q.size();
            List<Integer> list = new ArrayList<>(currLevelSize);
            Deque<TreeNode> newq = new ArrayDeque<>();
            if (direction > 0) {
                // 从左向右
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);
                    // 先放左孩子
                    if (curr.left != null) {
                        newq.offer(curr.left);
                    }
                    if (curr.right != null) {
                        newq.offer(curr.right);
                    }
                }
            } else {
                // 从右向左
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);
                    // 先放右孩子
                    if (curr.right != null) {
                        newq.offer(curr.right);
                    }    
                    if (curr.left != null) {
                        newq.offer(curr.left);
                    }
                }
            }
            q = newq;
            res.add(list);
            direction *= -1;
        }
        return res;
    }
}
// @lc code=end

