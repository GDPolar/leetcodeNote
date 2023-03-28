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
        List<List<String>> tickets1 = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("MUC");
        temp.add("LHR");
        tickets1.add(temp);
        temp = new ArrayList<>();
        temp.add("JFK");
        temp.add("MUC");
        tickets1.add(temp);
        temp = new ArrayList<>();
        temp.add("SFO");
        temp.add("SJC");
        tickets1.add(temp);
        temp = new ArrayList<>();
        temp.add("LHR");
        temp.add("SFO");
        tickets1.add(temp);

        temp = new ArrayList<>();
        List<List<String>> tickets2 = new ArrayList<>();
        temp.add("JFK");
        temp.add("SFO");
        tickets2.add(temp);
        temp = new ArrayList<>();
        temp.add("JFK");
        temp.add("ATL");
        tickets2.add(temp);
        temp = new ArrayList<>();
        temp.add("SFO");
        temp.add("ATL");
        tickets2.add(temp);
        temp = new ArrayList<>();
        temp.add("ATL");
        temp.add("JFK");
        tickets2.add(temp);
        temp = new ArrayList<>();
        temp.add("ATL");
        temp.add("SFO");
        tickets2.add(temp);

        new T().solveNQueens(4);
    }
    ArrayList<Integer> path = new ArrayList<>();
    char[][] board;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backTracking(n, n);
        return res;
    }

    private List<String> boardToStrings() {
        ArrayList<String> res = new ArrayList<>();    
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public void backTracking(int n, int left) {
        if (left == 0) {
            res.add(boardToStrings());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(n - left, i)) {
                board[n - left][i] = 'Q';      
                backTracking(n, left - 1);
                board[n - left][i] = '.';  
            }
        }
    }


    private boolean check(int curX, int curY) {
        for (int i = curX - 1; i >= 0; i--) {
            if (board[i][curY] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= curX && i <= curY; i++) {
            if (board[curX - i][curY - i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; curX + i <= board.length && curY + i <= board.length; i++) {
            if (board[curX + i][curY + i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
