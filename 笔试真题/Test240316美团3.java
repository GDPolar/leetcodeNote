package 笔试真题;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 240316美团3
 * 
题目：翻倍元素
小美拿到了一个数组，她每次操作会将除了第x个元素的其余元素翻倍，一共操作了q次。请你帮小美计算操作结束后所有元素之和。
由于答案过大，请对10^9+7取模。

输入描述：
第一行输入两个正整数n,q，代表数组的大小和操作次数。
第二行输入n个正整数ai，代表数组的元素。
第三行输入一个正整数q，代表操作的次数。
接下来的q行，每行输入一个正整数xi，代表第i次操作未被翻倍的元素。
1<=n,q<=10^5
1<=xi<=n
1<=ai<=10^9

输出描述：
一个整数，代表操作结束后所有元素之和模10^9+7的值。

样例输入：
4 2
1 2 3 4
1
2

样例输出：
34

说明：
第一次操作后，数组变成[1,4,6,8]
第二次操作后，数组变成[2,4,12,16]
所有元素之和为 34。


 */
public class Test240316美团3 {
    // 快速幂的基本使用
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        // pow[i] 表示元素 i 要乘以 2 的 i 次方
        int[] pow = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            pow[i] = q;
        }
        for (int i = 0; i < q; i++) {
            int index = sc.nextInt();
            pow[index-1]--;
        }
        long res = 0L;
        for (int i = 0; i < n; i++) {
            res += f(a[i], pow[i]);
            res %= mod;
        }
        System.out.println(res);
        sc.close();
    }

    public static long f(int a, int n) {
        long res = 1L;
        long t = 2;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= t;
                res %= mod;
            }
            t *= t;
            t %= mod;
            n >>= 1;
        }
        return res * a;
    }
}