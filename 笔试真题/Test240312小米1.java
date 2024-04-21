package 笔试真题;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 240312小米1
 * 
题目：偏爱的字符

小李天生偏爱一些字符，对于一个字符串，他总是想把字符串中的字符变成他偏爱的那些字符。如果字符串中某个字符不是他所偏爱的字符，
称为非偏爱字符，那么他会将该非偏爱字符替换为字符串中距离该字符最近的一个偏爱的字符。这里的距离定义即为字符在字符串中的对应
下标之差的绝对值。如果有不止一个偏爱的字符距离非偏爱字符最近，那么小李会选择最左边的那个偏爱字符来替换该非偏爱字符，
这样就保证了替换后的字符串是唯一的。小李的所有替换操作是同时进行的。
假定小李有m个偏爱的字符，依次为c1,c2...cm，当小李看到一个长度为n的字符串s时，请你输出小李在进行全部替换操作后形成的字符串。

输入描述：
第一行输入两个正整数n，m。
接下来一行输入m个字符c1,c2...cm，每两个字符之间用空格隔开，表示小李偏爱的字符。
接下来一行输入一个字符串s。
1≤n≤100000，1≤m≤26，保证题目中所有的字符均为大写字符，小李偏爱的字符互不相同，且偏爱字符至少出现一次。

输出描述：
输出一行字符串，表示小李将给定的字符串s替换后形成的字符串。

样例输入：
12 4
Z G B A
ZQWEGRTBYAAI

样例输出：
ZZZGGGBBBAAA

说明：字符Q为非偏爱字符，且偏爱字符Z距离它最近，所以替换成Z；同理E距离G最近，替换成G；对于字符W，偏爱字符Z和G与其距离相同，所以替换为左边的Z；.......对于字符 I ，右边没有偏爱字符，左边第一个偏爱字符是A，所以替换成字符A。同一个偏爱字符可能会在字符串中出现多次。


 */
public class Test240312小米1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int n = scanner.nextInt();
        int[] set = new int[26];
        while (n-- > 0) {
            char c = scanner.next().charAt(0);
            set[c - 'A'] = 1;
        }
        char[] charArray = scanner.next().toCharArray();
        int[] pos = new int[length];
        int preSize = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (set[charArray[i] - 'A'] == 1) {
                pos[preSize++] = i;
            }
        }
        if (preSize == 1) {
            Arrays.fill(charArray, charArray[pos[0]]);
        } else {
            for (int i = 0; i < pos[0]; i++) {
                charArray[i] = charArray[pos[0]];
            }
            int l = 0, r = 0;
            for (int i = 1; i < preSize; i++) {
                l = pos[i - 1]; r = pos[i];
                int middle = (l + r) / 2;
                for (int j = pos[i - 1] + 1; j <= middle; j++) {
                    charArray[j] = charArray[l];
                }
                for (int j = middle + 1; j < r; j++) {
                    charArray[j] = charArray[r];
                }
            }
            for (int i = r; i < length; i++) {
                charArray[i] = charArray[r];
            }
        }
        String res = new String(charArray);
        System.out.println(res);
        scanner.close();
    }
}