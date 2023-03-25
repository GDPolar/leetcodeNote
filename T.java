import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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


class TreeMaker {
    public static TreeNode retree(String s){
        String rs = s.substring(1,s.length()-1);
        String[] valarr = rs.split(",");
        int len = valarr.length;
        int i = 0;
        TreeNode head = new TreeNode(renumber(valarr[i]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(head);
        i++;
        while (i<len){
            TreeNode root = deque.pollFirst();
            if(i<len&&!"null".equals(valarr[i])){
                root.left = new TreeNode(renumber(valarr[i]));
                deque.addLast(root.left);

            }
            i++;
            if(i<len&&!"null".equals(valarr[i])){
                root.right = new TreeNode(renumber(valarr[i]));
                deque.addLast(root.right);
            }
            i++;
        }
        return head;
    }
    private static int renumber(String s){
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            res = res*10+(int)(arr[i]-'0');
        }
        return res;
    }
}


public class T {
    public static void main(String[] args) {
        int[] c = {10,1,2,7,6,1,5};
        TreeNode root1 = TreeMaker.retree("[1,3,2,5]");
        TreeNode root2 = TreeMaker.retree("[2,1,3,null,4,null,7]");
        new T().partition("efe");
    }
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 类似 45.组合问题，只不过组合问题中 path 每次添加的为当前选择的一个元素
        // 而此处添加的是从 start 开始到当前选择的元素的一串元素
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        String stemp;
        for (int i = start; i < s.length(); i++) {
            stemp = s.substring(start, i + 1);
            if (!isPalindrome(stemp)) {
                break;
            }
            path.add(stemp);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String p) {
        int start = 0, end = p.length() - 1;
        while (start < end) {
            if (p.charAt(start) != p.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
