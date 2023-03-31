/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 *
 * https://leetcode.cn/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (52.40%)
 * Likes:    1104
 * Dislikes: 0
 * Total Accepted:    193.9K
 * Total Submissions: 370.1K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key
 * 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 
 * 一般来说，删除节点可分为两个步骤：
 * 
 * 
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: root = [], key = 0
 * 输出: []
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 节点数的范围 [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10^5 <= key <= 10^5
 * 
 * 
 * 
 * 
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            // 右子树不动
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key) {
            // 左子树不动
            root.right = deleteNode(root.right, key);
        }
        else {
            // 待删除节点只有一个孩子节点或待删除结点是叶子节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右孩子都不为空，将左子树的最大节点或右子树的最小节点 T 作为 root,然后删除 T
            // 以下选择左子树的最大节点来替代
            // ① 左孩子节点无右子树，即左孩子节点就是 root 左子树最大的节点
            if (root.left.right == null) {
                root.left.right = root.right;
                root = root.left;
            }
            // ② 左孩子节点有右子树，沿着右下找到最大节点
            else{
                root.val = getLeftBiggest(root.left, root);
            }
        }
        return root;
    }

    private int getLeftBiggest(TreeNode r, TreeNode father) {
        while (r.right != null) {
            father = r;
            r = r.right;
        }
        // 此时 r 指向的节点 T 即为原待删除节点 root 的左子树的最大节点
        // T 节点一定无右子树
        // 删除该节点 T 并将其 val 返回用于替换
        father.right = r.left;
        return r.val;
    }
}
// @lc code=end

