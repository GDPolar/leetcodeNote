package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (58.63%)
 * Likes:    2323
 * Dislikes: 0
 * Total Accepted:    787.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
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
    public boolean isSymmetric(TreeNode root) {
        // 递归
        // return compareTwoTrees(root.left, root.right);

        
        // 迭代
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        TreeNode x, y;
        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            if (x == null && y == null) {
                continue;
            }
            if (x == null || y == null) {
                return false;
            }
            if (x.val != y.val) {
                return false;
            }
            queue.offer(x.left);
            queue.offer(y.right);
            queue.offer(x.right);
            queue.offer(y.left);
        }
        return true;

    }
    
    public boolean compareTwoTrees(TreeNode x, TreeNode y) {
        if (x == null && y == null) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        if (x.val != y.val) {
            return false;
        }
        return compareTwoTrees(x.right, y.left) && compareTwoTrees(x.left, y.right);

    }
}
// @lc code=end

