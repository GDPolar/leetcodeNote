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
        new T().lastStoneWeightII(new int[]{31,26,33,21,40});
        // int aaaa =  new T().lastStoneWeightI(new int[]{3,9,4,4});
        // int aaa =  new T().lastStoneWeightI(new int[]{35,33,30,25,19,11,53,40,36,10,31,23,26,13,14,18,33,22,16,22,16,28,16,72,25,23,19});
        //int aaa = new T().findTargetSumWays(new int[]{1,14,4,4,4,1,1,1}, 4);
        //int bbb = new T().findMaxForm(new String[]{"10","0","1"},1,1);
        //int aaa = new T().findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3);
        new T().nextGreaterElements(new int[]{1,4,2,4,4});
        
        
        //int[] aaa = new T().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(max);
        for (int i = 1; i <= nums.length; i++) {
            int curr = (max + i) % nums.length;
            if (nums[curr] == nums[max]) {
                res[curr] = -1;
            } else {
                while (!stack.isEmpty() && nums[curr] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[curr];
                    stack.pop();
                }
                stack.push(curr);
            }
        }
        // 最大值不唯一
        return res;
    }


    public int[] dailyTemperatures(int[] temperatures) {
        // // 要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，用单调栈
        // int[] ans = new int[temperatures.length];
        // if (temperatures.length == 1) {
        //     return ans;
        // }
        // Deque<Integer> stack = new LinkedList<>();
        // // 栈内存放的是 index
        // // 栈底到栈顶，由大到小，这样从左遍历数组就能找到每个元素右侧第一个大于自己的元素   
        // stack.push(0);
        // for (int i = 1; i < temperatures.length; i++) {
        //     while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        //         ans[stack.peek()] = i - stack.pop();
        //     }
        //     stack.push(i);
        // }
        // return ans;


        int[] res = new int[temperatures.length];
        if (temperatures.length == 1) {
            return res;
        }
        int temp = temperatures.length - 1;
        for (int i = temperatures.length - 2; i >=0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                res[i] = 1;
            } else {
                int j;
                for (j = i; j <= temp; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        break;
                    }
                }
                if (j > temp) {
                    temp = i;
                    res[i] = 0;
                } else {
                    res[i] = j - i;
                }
            }
        }
        return res;
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 加法的和为 x, 减法的和就为 sum - x
        // 要满足 x - (sum - x) == target -> 2x == target + sum 
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
            return 0;
        }
        int capacity = (sum + target) / 2;
        // dp[j] 表示用 nums 数组填满容积为 j 的背包，有 dp[j] 种填法
        int[] dp = new int[capacity + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            // dp[j] 表示用 nums[0:i] 的元素填满容积为 j 的背包，有 dp[j] 种填法
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[capacity];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        // 初始化
        for (int i = stones[0]; i < dp[0].length; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                }
            }
        }
        int ans = 0;
        for (int i = dp[0].length - 1; i >= 0; i--) {
            if (dp[dp.length - 1][i] != 0) {
                ans = dp[dp.length - 1][i];
                break;
            }
        }
        return Math.abs(sum - 2 * ans);
    }

    int target;
    int ans = Integer.MAX_VALUE;
    public int lastStoneWeightI(int[] stones) {
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
        System.out.println("ans = " + ans);
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
            countAfter++;
            // 子集和大于等于 sum/2
            // 判断其是不是所有答案中和最小的

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.print(": " + sum + "\n");
            if (sum >= target){
                ans = Math.min(sum, ans);
            }
            return true; 
        }

        // 先选，再不选，使尽早出现 sum >= target
        list.add(stones[idx]);
        if (backtracking(stones, idx - 1, sum + stones[idx]) == true) {
            list.remove(list.size() - 1);
            
            return backtracking(stones, idx - 1, sum); 
        }

        // 运行到此处，表明 backtracking(stones, idx - 1, sum + stones[idx]) == false
        // 即在 backtracking(stones, idx - 1, sum + stones[idx]) 中已经找到了最终结果使 sum == target
        return false;
    }
}
