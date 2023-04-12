import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    
}


public class T {

    // 字符串转为二叉树树
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

    // 字符串转为二维数组
    public static int[][] twoD(String s, int outterLength, int innerLength) {
        int[][] res = new int[outterLength][];
        for (int i = 0; i < outterLength; i++) {
            res[i] = new int[innerLength];
        }
        int[] nums = new int[outterLength * innerLength];
        int k = 0;
        StringBuilder sb = null;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '[') {
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                nums[k++] = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ',') {
                nums[k++] = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        for (int i = 0; i < outterLength; i++) {
            for (int j = 0; j < innerLength; j++) {
                res[i][j] = nums[i * innerLength + j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] c = {10,1,2,7,6,1,5};
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

        int[][] data = twoD("[[12,-1],[0,4],[11,-4]]", 3, 2);
        new T().eraseOverlapIntervals(twoD("[[0,2],[1,3],[2,4],[3,5],[4,6]]", 5, 2));
        int a = 1;
    }
    int ans = Integer.MAX_VALUE;
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        int ans = 0;
        Arrays.sort(intervals, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return Integer.compare(e1[1], e2[1]);
            }
            return Integer.compare(e1[0], e2[0]);
        });
        int[] pos = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == pos[0]) {
                ans++;
            } else if (intervals[i][0] >= pos[1]){
                pos = intervals[i];
                continue;
            } else if (intervals[i][1] <= pos[1]) {
                pos = intervals[i];
                ans++;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
