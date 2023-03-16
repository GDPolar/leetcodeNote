import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (76.31%)
 * Likes:    1003
 * Dislikes: 0
 * Total Accepted:    585K
 * Total Submissions: 766.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
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
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // 根据先序遍历的思路，进行调整
        // 先序是中左右，后序是左右中
        // 则将先序调整为中右左，然后颠倒结果得到左右中
        if (root == null) {
            return res;
        }
        // 维护一个栈
        stack.push(root);
        TreeNode t;
        while (!stack.isEmpty()) {
            // 中出栈
            t = stack.pop();    
            res.add(t.val);
            // 左入栈
            if (t.left != null) {
                stack.push(t.left);
            }
            // 右入栈
            if (t.right != null) {
                stack.push(t.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /*
    // 递归，思路简单
    public void f(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        f(root.left, res);
        f(root.right, res);
        res.add(root.val);
    }
     */
}
// @lc code=end

