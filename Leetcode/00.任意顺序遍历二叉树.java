package Leetcode;

import java.util.*;


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

class Solution{

    // 中序遍历，左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 先序遍历，中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    // 后序遍历，左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // prev 标记右孩子已经被访问过，防止重复访问
            if (root.right != null && root.right != prev) {
                stack.push(root);
                root = root.right;
            } else {
                res.add(root.val);
                prev = root;
                // 该节点的左右孩子都访问了，若不将 root 标记为 null，下一次循环又会访问左孩子
                root = null;
            }
        }
        return res;
    }

    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> currentLevelRes = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.remove();
                currentLevelRes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(currentLevelRes);
        }
        return res;
    }

    public List<Integer> traversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        // 统一写法的核心是不边访问边操作，而是访问和操作分开处理
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if (t != null) {
                // 为避免重复操作，先抛出当前节点，待会再放回去
                stack.pop(); 
                
                /*
                 * 根据具体的访问顺序，修改如下代码的顺序：
                 * （入栈顺序和读取顺序相反）
                 * 1、中序遍历顺序左中右，入栈顺序：右中左
                 * 2、先序遍历顺序中左右，入栈顺序：右左中
                 * 3、后序遍历顺序左右中，入栈顺序：中右左
                 * 4、自定义顺序ABC：入栈顺序为CBA
                 */ 

                // * 右节点入栈
                if (t.right != null) {
                    stack.push(t.right);
                }
                // * 左节点入栈
                if (t.left != null) {
                    stack.push(t.left);
                }
                // * 当前节点入栈，再加入一个空节点做标记
                stack.push(t);
                stack.push(null);
            } 
            // 检测到被标记的空节点，进行处理
            else {
                // 先丢掉空节点
                stack.pop();
                // 获取待处理的节点
                t = stack.pop();
                res.add(t.val);
            }
        }
        return res;
    }
}