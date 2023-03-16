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
    public List<Integer> inorderTraversal(TreeNode root) {
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