import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
 *
 * https://leetcode.cn/problems/binary-tree-cameras/description/
 *
 * algorithms
 * Hard (52.28%)
 * Likes:    581
 * Dislikes: 0
 * Total Accepted:    56.7K
 * Total Submissions: 108.6K
 * Testcase Example:  '[0,0,null,0,0]'
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 
 * 计算监控树的所有节点所需的最小摄像头数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
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
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        // 根节点未被监视到，则在根节点加一个相机
        if(f(root) == 0) {
            ans++;
        }
        return ans;
    }

    // 0 表示自己未被监视
    // 1 表示父节点不用考虑自己，即该节点为空节点 或 该节点没有相机但可被其子节点观察到
    // 2 表示自己有相机，可以观察到父节点
    public int f(TreeNode root) {
        // 节点为空，告诉父节点不需考虑自己
        // 空节点设为 1，目的是让叶子节点不要装相机，但让叶子节点的父节点装相机
        if (root == null) {
            return 1;
        }
        int l = f(root.left);
        int r = f(root.right);
        if (l == 0 || r == 0) {
            // 00 01 10 02 20
            ans++;
            return 2;
        }
        if (l == 2 || r == 2) {
            // 12 21 22
            return 1;
        } 
        // 11
        return 0;
    }
}
// @lc code=end

