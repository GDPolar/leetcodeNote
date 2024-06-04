package Leetcode;


/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (80.73%)
 * Likes:    897
 * Dislikes: 0
 * Total Accepted:    266.2K
 * Total Submissions: 329.7K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 
 * 完全二叉树
 * 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h
 * 层，则该层包含 1~ 2^h 个节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 
 * 题目数据保证输入的树是 完全二叉树
 * 
 * 
 * 
 * 
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
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
    // PBT（Perfect Binary Tree)：深度为 k 且有 2^(k+1)-1 个结点的二叉树
    // CBT（Complete Binary Tree）：PBT 或 PBT 的最后一层的节点都位于最左侧
    // FBT（Full Binary Tree)：每个节点度为 0 或 2
    public int countNodes(TreeNode root) {
        // CBT 只有两种情况
        // 1、PBT，可直接算得个数
        // 2、递归左右子节点，递归到某一深度一定会有左或右子节点为 PBT
        if (root == null) {
            return 0;
        }
        int depth = getPBTDepth(root);
        if (-1 != depth) {
            // 用位运算优化
            return (1 << depth) - 1;
            // return (int)Math.pow(2, depth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 如果是 PBT，则返回深度，否则返回 -1
    public int getPBTDepth(TreeNode root) {
        int depth = 1;
        TreeNode rightmost = root.right, leftmost = root.left;
        // 不是 PBT 的 CBT，一定是右子树深度小于左子树深度
        while (rightmost != null) {
            rightmost = rightmost.right;
            leftmost = leftmost.left;
            depth++;
        }
        if (leftmost == null) {
            return depth;
        } else {
            return -1;
        }
    }
}
// @lc code=end

