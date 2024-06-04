package Leetcode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 *
 * https://leetcode.cn/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (61.08%)
 * Likes:    1689
 * Dislikes: 0
 * Total Accepted:    275.8K
 * Total Submissions: 451.5K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果
 * 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7 
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 
 * 示例 2:
 * 
 * 
 * 
 * 
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 树的节点数在 [1, 10^4] 范围内
 * 0 <= Node.val <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

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

    public int rob(TreeNode root) {
        // 方法一：
        // dp 思想，记录每一个节点选择或不选择当前节点获得的最大金额
        // 0 表示选择，1 表示不选择
        // 后序遍历，每个节点返回两个数字交由上层节点处理
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);  
        int[] res = new int[2];
        // 选择当前节点，则不能选择当前节点的孩子节点
        res[0] = root.val + left[1] + right[1];
        // 不选择当前节点，则可以选择或不选择当前节点的孩子节点
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


    // 方法二：记忆化优化暴力递归
    // map 保存以 key 为根的树所能获取的最高金额
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            map.put(root, root.val);
            return root.val;
        }
        // 不选择当前节点，考虑选择当前节点的左孩子和右孩子
        int no = rob(root.left) + rob(root.right);
        // 选择当前节点，则不可选择当前节点的左孩子和右孩子
        int yes = root.val;
        if (root.left != null) {
            // 可以考虑当前节点左孩子的孩子节点
            yes += rob(root.left.left);
            yes += rob(root.left.right);
        }
        if (root.right != null) {
            // 可以考虑当前节点右孩子的孩子节点
            yes += rob(root.right.left);
            yes += rob(root.right.right);
        }
        int res = Math.max(no, yes);
        map.put(root, res);
        return res;
    }
}
// @lc code=end

