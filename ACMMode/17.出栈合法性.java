/**
 * 
题目描述
已知自然数1，2，...，N（1<=N<=100）依次入栈，请问序列C1，C2，...，CN是否为合法的出栈序列。

输入描述
输入包含多组测试数据。
每组测试数据的第一行为整数N（1<=N<=100），当N=0时，输入结束。
第二行为N个正整数，以空格隔开，为出栈序列。

输出描述
对于每组输入，输出结果为一行字符串。
如给出的序列是合法的出栈序列，则输出Yes，否则输出No。

输入示例
5
3 4 2 1 5
5
3 5 1 4 2
0

输出示例
Yes
No

 */
import java.util.*;

public class Main {
    static int num;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            // ArrayDeque 实现 栈、队列、双端队列
            Deque<Integer> stack = new ArrayDeque<>();
            int flag = 0;
            num = 1;
            while (n-- > 0) {
                int x = sc.nextInt();
                // flag 实现剪枝，减少判断
                if (flag < 0 || !check(x, stack)) {
                    flag = -1;
                }
            }
            if (flag < 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
        sc.close();
    }
    
    public static boolean check(int x, Deque<Integer> stack) {
        if (x >= num) {
            for (int i = num; i <= x; i++) {
                stack.push(i);
            }
            stack.pop();
            num = x + 1;
            return true;
        }
        return stack.pop() == x;
    }
}