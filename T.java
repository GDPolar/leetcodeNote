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
        int[] a = new int[1];
        int[][] aa = new int[1][];
        List<String> list = new ArrayList<>();
        
        int[][] data = twoD("[[1,3],[2,6],[8,10],[15,18]]", 4, 2);
        // -2-7+4-1+8-1
        new T().lastStoneWeightII(new int[]{4});
        int aaa =  new T().lastStoneWeightII(new int[]{2,7,4,1,8,1});
        int bbb = 1;
    }
    int target;
    int ans = Integer.MAX_VALUE;
    public int lastStoneWeightII(int[] stones) {
        // 问题转化为：
        // 将给定的数组分为两个子集，欲求这两个子集的和的最小差值 
        // 答案求的两个子集就分别是 小于等于 sum/2 的最大和子集、大于等于 sum/2 的最小和子集
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        target = sum / 2;
        Arrays.sort(stones);

        // 通过回溯找和大于等于 sum/2 的最小子集
        // 从大端开始
        backtracking(stones, stones.length - 1, 0);

        return Math.abs(sum - 2 * ans); 
    
    }
    
    // 返回值表示是否还要继续找
    private boolean backtracking(int[] stones, int idx, int sum) { //找大于target的最小ns
        
        // 直接速通，找到了最终答案 0 或 1
        // sum 为奇数，最终答案为 1
        // sum 为偶数，最终答案为 0
        if (sum == target) {
            ans = target;
            return false;
        } 

        // 剪枝
        // 若 sum >= ans，后续操作必定也 > ans
        // 故跳过此次
        if (sum >= ans) {
            return true;
        }

        // 从后到前遍历完了一遍数组
        if (idx < 0) {
            // 子集和大于等于 sum/2
            // 判断其是不是所有答案中和最小的
            if (sum >= target){
                ans = Math.min(sum, ans);
            }
            return true; 
        }

        // 先选，再不选，使尽早出现 sum >= target
        if (backtracking(stones, idx - 1, sum + stones[idx]) == true) {
            return backtracking(stones, idx - 1, sum); 
        }

        // 运行到此处，表明 backtracking(stones, idx - 1, sum + stones[idx]) == false
        // 即在 backtracking(stones, idx - 1, sum + stones[idx]) 中已经找到了最终结果使 sum == target
        return false;
    }
}
