package Leetcode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (73.62%)
 * Likes:    1696
 * Dislikes: 0
 * Total Accepted:    494.4K
 * Total Submissions: 668.2K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 2000] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * 
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
    // 要求展开后的单链表与二叉树先序遍历顺序相同，即处理顺序为 中左右
    // 右子树挂到左子树的最右下处，然后用左子树代替右子树
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node;
        if ((node = root.left) != null) {
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten1(root.right);
    }

    // 递归，不找左子树的最右下角
    // 如果直接先序递归（中左右），将当前节点的处理好的左子树赋给右子树，右子树就丢失了
    // 因此反先序递归（右左中），先处理好当前节点的右子树
    // 相应地，这样的话就不是左子树赋给右子树，而将当前节点的右指针更新为上一个节点
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
// @lc code=end

