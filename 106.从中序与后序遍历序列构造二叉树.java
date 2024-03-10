/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (72.37%)
 * Likes:    962
 * Dislikes: 0
 * Total Accepted:    266.4K
 * Total Submissions: 368.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder
 * 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
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
    int[] inorder; int[] postorder;
    HashMap<Integer, Integer> inorderIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildTreeWithBoundary(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTreeWithBoundary(int inBegin, int inEnd, int poBegin, int poEnd) {
        if (inBegin > inEnd || poBegin > poEnd) {
            return null;
        }
        // 后序的最后为根节点，中序的根节点左部分为根的左子树、右部分为根的右子树
        int rootIndex = inorderIndex.get(postorder[poEnd]);

        int lengthOfLeft = rootIndex - inBegin;
        int lengthOfRight = inEnd - rootIndex;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 注意切割时保持一致性，此处保持左闭右闭
        root.left = buildTreeWithBoundary(inBegin, rootIndex - 1, poBegin, poBegin + lengthOfLeft - 1);
        root.right = buildTreeWithBoundary(rootIndex + 1, inEnd, poEnd - lengthOfRight , poEnd - 1);
        
        return root;
    }


}
// @lc code=end

