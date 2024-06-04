package Leetcode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.40%)
 * Likes:    1903
 * Dislikes: 0
 * Total Accepted:    473.7K
 * Total Submissions: 663.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
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
    int[] preorder; int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTreeWithBeginAndEnd(0, inorder.length - 1, 0, preorder.length - 1);
    }

    
    public TreeNode buildTreeWithBeginAndEnd(int inBegin, int inEnd, int preBegin, int preEnd) {
        if (inBegin > inEnd || preBegin > preEnd) {
            return null;
        }
        // 前序的第一个为根节点，中序的根节点左部分为根的左子树、右部分为根的右子树
        int rootIndex;
        for (rootIndex = inBegin; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == preorder[preBegin]) {
                break;
            }
        }
        int lengthOfLeft = rootIndex - inBegin;
        int lengthOfRight = inEnd - rootIndex;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 注意切割时保持一致性，此处保持左闭右闭
        root.left = buildTreeWithBeginAndEnd(inBegin, rootIndex - 1, preBegin + 1, preBegin + lengthOfLeft);
        root.right = buildTreeWithBeginAndEnd(rootIndex + 1, inEnd, preEnd - lengthOfRight + 1, preEnd);
        return root;
    }

}
// @lc code=end

