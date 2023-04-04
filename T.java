import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
        // [4,2,4]\n1
        // [4,2,6]\n3

        new T().topKFrequent(new int[]{4,2,4}, 1);
        new T().topKFrequent(new int[]{2,3,4,5,2,4,3,1,1,1,1,2,2,3},3);
        int a = 2;
    }
    Deque<Integer> deque = new LinkedList<>();
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        Arrays.sort(nums);
        int prev = nums[0];
        int num = 0;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.peek();
            queue.remove();
        }
        return res;
    }

}
