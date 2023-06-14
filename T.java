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

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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
    public static TreeNode retree(String s) {
        String rs = s.substring(1, s.length() - 1);
        String[] valarr = rs.split(",");
        int len = valarr.length;
        int i = 0;
        TreeNode head = new TreeNode(renumber(valarr[i]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(head);
        i++;
        while (i < len) {
            TreeNode root = deque.pollFirst();
            if (i < len && !"null".equals(valarr[i])) {
                root.left = new TreeNode(renumber(valarr[i]));
                deque.addLast(root.left);

            }
            i++;
            if (i < len && !"null".equals(valarr[i])) {
                root.right = new TreeNode(renumber(valarr[i]));
                deque.addLast(root.right);
            }
            i++;
        }
        return head;
    }

    private static int renumber(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res * 10 + (int) (arr[i] - '0');
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
        System.out.println();
    }

    public void printArray(long[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
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
        // t.printArray(new int[]{31,26,33,21,40} );
        int[][] data = twoD("[[1,3],[2,6],[8,10],[15,18]]", 4, 2);
        // t.printArray(data);
        // -2-7+4-1+8-1
        // new T().lastStoneWeightII(new int[]{31,26,33,21,40});
        // int aaaa = new T().lastStoneWeightI(new int[]{3,9,4,4});
        // int aaa = new T().lastStoneWeightI(new
        // int[]{35,33,30,25,19,11,53,40,36,10,31,23,26,13,14,18,33,22,16,22,16,28,16,72,25,23,19});
        // int aaa = new T().findTargetSumWays(new int[]{1,14,4,4,4,1,1,1}, 4);
        // int bbb = new T().findMaxForm(new String[]{"10","0","1"},1,1);
        // int aaa = new T().findMaxForm(new String[]{"10","0001","111001","1","0"}, 4,
        // 3);
        // new T().nextGreaterElements(new int[]{1,4,2,4,4});

        // int f = 1;
        // int max;
        // int[] aaa = new int[20000000];
        // for (int i = 0; i < aaa.length; i++) {
        // aaa[i] = new Random().nextInt(100);
        // }

        // long b = System.currentTimeMillis();
        // for (long i = 0; i < 100l; i++) {
        // max = aaa[0];
        // for (int j = 0; j < aaa.length; j++) {
        // if (max < aaa[j]) {
        // max = aaa[j];
        // }
        // }
        // }
        // System.out.println( System.currentTimeMillis() - b);

        // b = System.currentTimeMillis();
        // for (long i = 0; i < 100l; i++) {
        // max = aaa[0];
        // for (int j = 0; j < aaa.length; j++) {
        // max = Math.max(max, aaa[j]);
        // }
        // }
        // System.out.println( System.currentTimeMillis() - b);

        // int[] aaa = new T().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        new T().rob(retree("[3,2,3,null,3,null,1]"));

        // return ans;
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        int no = rob(root.left) + rob(root.right);
        int yes = root.val;
        if (root.left != null) {
            yes += rob(root.left);
            yes += rob(root.left.right);
        }
        if (root.right != null) {
            yes += rob(root.right);
            yes += rob(root.right.right);
        }
        return Math.max(no, yes);
    }

    public int rob2(int[] nums) {
        // 假设数组长度为5，则下标为 0,1,2,3,4
        // 考虑从下标 1 到 下标 3 中选得到的最大价值 A
        // 考虑从下标 0 到 下标 3 中选得到的最大价值 B
        //      如果 B 没有选下标 0，那么 B 等于 A
        //      如果 B 选了下标 0，那么 B 大于或等于 A
        //      即 B >= A
        // 考虑从下标 1 到 下标 4 中选得到的最大价值 C
        //      如果 C 没有选下标 4，那么 C 等于 A
        //      如果 C 选了下标 4，那么 C 大于或等于 A
        //      即 C >= A
        // 考虑从下标 0 到 下标 4 中选得到的最大价值 D
        //      如果 D 没有选下标 0，没有选下标 4，那么 D 等于 A
        //      如果 D 没有选下标 0，选了下标 4，那么 D 等于 C
        //      如果 D 没有选下标 4，选了下标 0，那么 D 等于 B
        //      即 D = Max(A, B, C) = Max(B, C)

        return Math.max(f(nums, 0, nums.length - 1), f(nums, 1, nums.length));
    }


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int sum = 0;
        // dp[i][j][k] 表示从前 i 个工作中选择，消耗人数不超过 j，利润至少为 k 的方案数
        // dp[i][j][k] 
        // dp[i - 1][j][k]  dp[i][j - group[i]][k - profit[i]]
        int mod = (int)(1e9 + 7);
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        
        // dp[0][j][0] 表示不选任何工作，消耗人数不超过 j，利润大于等于 0 的方案数
        // 有且只有一种情况
        // dp[0][j][k], k > 0 表示不选任何工作，消耗人数不超过 j，利润大于 0 的方案数
        // 没有任何情况满足，都为 0
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j][0] = 1;
        }        
        for (int i = 1; i < dp.length; i++) {
            int index = i - 1;
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    // 不选当前工作
                    dp[i][j][k] = dp[i - 1][j][k];
                    // 注意考虑转移方程时对应的实际意义！
                    // 此题中利润大于等于一个负数是合理的，数值上等价于利润为 0
                    if (j >= group[index]) {
                        // 可选当前工作
                        dp[i][j][k] += dp[i - 1][j - group[index]][Math.max(0, k - profit[index])];
                        dp[i][j][k] %= mod;
                    }

                }
            }
        }
        // 567 568 578
        // 23  23  26
        int ans = 0;
        for (int i = minProfit; i < dp[0].length; i++) {
            
        }
        return ans;
    }

    public int numSquares(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; ; i++) {
            int t = i * i;
            if (t == n) {
                return 1;
            } else if (t > n) {
                break;
            } else {
                nums.add(t);
            }
        }
        // 用 nums 中的数字填满容量为 n 的完全背包
        int[] dp = new int[n + 1];
        // 第一行
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int t = nums.get(0);
        for (int j = t; j < dp.length; j++) {
            if (j % t == 0) {
                dp[j] = j / t;
            }
        }

        for (int i = 1; i < nums.size(); i++) {
            t = nums.get(i);
            for (int j = t; j < dp.length; j++) {
                for (int k = 1; j >= t * k; k++) {
                    dp[j] = Math.min(dp[j], dp[j - t * k] + k);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
