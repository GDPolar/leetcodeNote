package Leetcode;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode.cn/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (47.83%)
 * Likes:    1883
 * Dislikes: 0
 * Total Accepted:    320.6K
 * Total Submissions: 673.7K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9  
 * -1000  
 * 
 * 
 */

 import java.util.HashMap;
 
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
    int res = 0;
    long targetSum;
    HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        this.targetSum = targetSum;
        f(root, 0L);
        return res;
    }

    public void f(TreeNode root, long currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (map.containsKey(currentSum - targetSum)) {
            res += map.get(currentSum - targetSum);
        }
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        f(root.left, currentSum);
        f(root.right, currentSum);
        // 当前节点及子树完成，撤销当前节点对当前路径和的影响
        map.put(currentSum, map.get(currentSum) - 1);
    }
}
// @lc code=end

