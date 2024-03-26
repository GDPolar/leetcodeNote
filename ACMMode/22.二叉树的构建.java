import java.util.*;

class TreeNode {
    String val;
    int left;
    int right;
    public TreeNode() {}
    public TreeNode(String val) {this.val = val;}
    public TreeNode(String val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            TreeNode[] tree = new TreeNode[n + 1];
            for (int i = 1; i <= n; i++) {
                String c = sc.next();
                int left = sc.nextInt();
                int right = sc.nextInt();
                tree[i] = new TreeNode(c, left, right);
            }
            preorder(tree[1], tree);
            System.out.println();
            inorder(tree[1], tree);
            System.out.println();
            postorder(tree[1], tree);
            System.out.println();
        }
        sc.close();
    }
    
    public static void preorder(TreeNode root, TreeNode[] tree) {
        System.out.print(root.val);
        if (root.left != 0) {
            preorder(tree[root.left], tree);
        }
        if (root.right != 0) {
            preorder(tree[root.right], tree);
        }
    }

    public static void inorder(TreeNode root, TreeNode[] tree) {
        if (root.left != 0) {
            inorder(tree[root.left], tree);
        }
        System.out.print(root.val);
        if (root.right != 0) {
            inorder(tree[root.right], tree);
        }
    }
    
    public static void postorder(TreeNode root, TreeNode[] tree) {
        if (root.left != 0) {
            postorder(tree[root.left], tree);
        }
        if (root.right != 0) {
            postorder(tree[root.right], tree);
        }
        System.out.print(root.val);
    }
} 