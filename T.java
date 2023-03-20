import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}; 


public class T {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        
        System.out.println(new T().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if (inorder.length == 0) {
            return null;
        }
        return buildTreeWithBeginAndEnd(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTreeWithBeginAndEnd(int[] inorder, int[] postorder, int inBegin, int inEnd, int poBegin, int poEnd) {
        if (inBegin > inEnd || poBegin > poEnd) {
            return null;
        }
        int rootIndex;
        for (rootIndex = inBegin; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == postorder[poEnd]) {
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTreeWithBeginAndEnd(inorder, postorder, inBegin, rootIndex - 1, poBegin, rootIndex - 1);
        root.right = buildTreeWithBeginAndEnd(inorder, postorder, rootIndex + 1, inEnd, rootIndex, poEnd - 1);
        return root;
    }


}
