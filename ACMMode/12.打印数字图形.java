/**
 * 
题目描述
先要求你从键盘输入一个整数n（1<=n<=9），打印出指定的数字图形。

输入描述
输入包含多组测试数据。每组输入一个整数n（1<=n<=9）。

输出描述
对于每组输入，输出指定的数字图形。
注意：每行最后一个数字后没有任何字符。

输入示例
5

输出示例
    1
   121
  12321
 1234321
123454321
 1234321
  12321
   121
    1

 */
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            for (int i = 1; i <= n; i++) {
                f(i, n);
            }
            for (int i = n - 1; i >= 1; i--) {
                f(i, n);
            }
        }
        sc.close();
    }
    
    public static void f(int i, int n) {
        int j = 1;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n - i; k++) {
            sb.append(" ");
        }
        while (j <= i) {
            sb.append(j++);
        }
        j = i - 1;
        while (j > 0) {
            sb.append(j--);
        }
        System.out.println(sb.toString());
    }
}