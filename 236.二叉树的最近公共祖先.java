/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (69.61%)
 * Likes:    2201
 * Dislikes: 0
 * Total Accepted:    515.2K
 * Total Submissions: 739.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [2, 10^5] 内。
 * -10^9 
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 二叉树只能通过后序遍历实现从底向上遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 一直到叶子节点都未找到，则返回 null
        if (root == null) {
            return null;
        }
        // 找到，则返回当前节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 获得在左、右子树查找 p 或 q 的结果
        // 若不存在于子树，则会返回 null
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        // p、q 位于左、右子树，则当前节点即为结果，一路传上去
        if (l != null && r != null) {
            return root;
        }
        if (l != null) {
            return l;
        }
        return r;    
    }
}
// @lc code=end

