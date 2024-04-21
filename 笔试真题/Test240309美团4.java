package 笔试真题;

import java.util.Scanner;

/**
 * 小美的区间删除

小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积未尾至少有k个0。
小美想知道，一共有多少种不同的删除方案?

输入描述：
第一行输入两个正整数n，k 第二行输入n个正整数ai，代表小美拿到的数组 
1≤n,k≤10…^5 1≤ai≤10^9


样例输入：
5 2
2 5 3 4 20

样例输出：
4

说明：
第一个方案，删除[3]
第二个方案，删除[4]
第三个方案，删除[3,4]
第四个方案，删除[2]

 */

public class Test240309美团4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        // 因数分解后，只有一组2和一组5相乘，乘积末尾能得到一个0，2*5=10，
        // 末尾0的数量 == min(i,j) ， 因子中有i个2和j个5
        int cnt2 = 0, cnt5 = 0;
        int[] c2 = new int[n], c5 = new int[n];
        for (int i = 0; i < n; i++) {
            int num = a[i];
            while (num % 2 == 0) {
                num /= 2;
                c2[i]++;
            }
            while (num % 5 == 0) {
                num /= 5;
                c5[i]++;
            }
            cnt2 += c2[i];
            cnt5 += c5[i];
        }
        long res = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt2 -= c2[r];
            cnt5 -= c5[r];
            while (Math.min(cnt2, cnt5) < k && l <= r) {
                // Math.min(cnt2, cnt5) < k 表示删除区间 [l,r] 会导致结果不符合要求，则从l开始向右缩小删减区间
                cnt2 += c2[l];
                cnt5 += c5[l];
                l++;
            }
            // (a,b,c,d,e,f,g)
            // 若删除区间 [b,e] 后，结果符合要求
            // 那么删除区间 [c,e] 或 [d,e] 或 [e,e] 后，结果仍符合要求
            res += (long) (r - l + 1);    
        }
        System.out.println(res);
    }
}
