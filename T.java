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

    public void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public void printArray(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    

    static int countAfter = 0;
    ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] a = new int[1];
        int[][] aa = new int[1][];
        List<String> list = new ArrayList<>();
        T t = new T();
        //t.printArray(new int[]{31,26,33,21,40} );
        int[][] data = twoD("[[1,3],[2,6],[8,10],[15,18]]", 4, 2);
        //t.printArray(data);
        // -2-7+4-1+8-1
        //new T().lastStoneWeightII(new int[]{31,26,33,21,40});
        // int aaaa =  new T().lastStoneWeightI(new int[]{3,9,4,4});
        // int aaa =  new T().lastStoneWeightI(new int[]{35,33,30,25,19,11,53,40,36,10,31,23,26,13,14,18,33,22,16,22,16,28,16,72,25,23,19});
        //int aaa = new T().findTargetSumWays(new int[]{1,14,4,4,4,1,1,1}, 4);
        //int bbb = new T().findMaxForm(new String[]{"10","0","1"},1,1);
        //int aaa = new T().findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3);
        //new T().nextGreaterElements(new int[]{1,4,2,4,4});
        
        
        
        // int f = 1;
        // int max;
        // int[] aaa = new int[20000000];
        // for (int i = 0; i < aaa.length; i++) {
        //     aaa[i] = new Random().nextInt(100);
        // }

        // long b =  System.currentTimeMillis();
        // for (long i = 0; i < 100l; i++) {
        //     max = aaa[0];
        //     for (int j = 0; j < aaa.length; j++) {
        //         if (max < aaa[j]) {
        //             max = aaa[j];
        //         } 
        //     }
        // }
        // System.out.println( System.currentTimeMillis() - b);
        
        // b =  System.currentTimeMillis();
        // for (long i = 0; i < 100l; i++) {
        //     max = aaa[0];
        //     for (int j = 0; j < aaa.length; j++) {
        //         max = Math.max(max, aaa[j]);
        //     }
        // }
        // System.out.println( System.currentTimeMillis() - b);
  
        //int[] aaa = new T().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        //new T().trap(new int[]{4,2,0,3,2,5});
    
    
    }


        return ans;
    }
}
