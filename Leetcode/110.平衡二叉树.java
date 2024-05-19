/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (57.49%)
 * Likes:    1265
 * Dislikes: 0
 * Total Accepted:    475.3K
 * Total Submissions: 826.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 
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
    public boolean isBalanced(TreeNode root) {
        // 自底向上
        return getHeightIfIsBalanced(root) != -1;
    }

    // 若该树为平衡二叉树，则返回高度，否则返回 -1
    public int getHeightIfIsBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeightIfIsBalanced(root.left);
        // 剪枝。若左子树不是平衡二叉树，则不用计算右子树
        // 而是需要将 整棵树不是平衡二叉树 这一结论尽快传回根节点
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeght = getHeightIfIsBalanced(root.right);
        if (rightHeght == -1 || Math.abs(leftHeight - rightHeght) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeght);
    }
}
// @lc code=end

