/**
 * 
题目描述
给你一棵二叉树的前序遍历和中序遍历结果，要求你写出这棵二叉树的后序遍历结果。

输入描述
输入包含多组测试数据。每组输入包含两个字符串，分别表示二叉树的前序遍历和中序遍历结果。每个字符串由不重复的大写字母组成。

输出描述
对于每组输入，输出对应的二叉树的后续遍历结果。

输入示例
DBACEGF ABCDEFG
BCAD CBAD

输出示例
ACBFGED
CDAB


 */
import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(char val) {this.val = val;}
    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String preorder = sc.next();
            String inorder = sc.next();
            TreeNode root = build(preorder.toCharArray(), inorder.toCharArray(), 0, preorder.length() - 1, 0, inorder.length()- 1);
            postorder(root);
            System.out.println();
        }
    }
    
    public static TreeNode build (char[] preorder, char[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = -1;
        int leftLength = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                leftLength = rootIndex - inBegin;
                break;
            }
        }
        root.left = build(preorder, inorder, preBegin + 1, preBegin + leftLength, inBegin, rootIndex - 1);
        root.right = build(preorder, inorder, preBegin + leftLength + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }
    
    public static void postorder (TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }
}