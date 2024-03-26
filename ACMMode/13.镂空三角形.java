/**
 * 
题目描述
把一个字符三角形掏空，就能节省材料成本，减轻重量，但关键是为了追求另一种视觉效果。在设计的过程中，需要给出各种花纹的材料和大小尺寸的三角形样板，通过电脑临时做出来，以便看看效果。

输入描述
每行包含一个字符和一个整数n(0<n<41)，不同的字符表示不同的花纹，整数n表示等腰三角形的高。显然其底边长为2n-1。如果遇到@字符，则表示所做出来的样板三角形已经够了。

输出描述
每个样板三角形之间应空上一行，三角形的中间为空。行末没有多余的空格。每条结果后需要再多输出一个空行。

输入示例
X 2
A 7
@

输出示例
 X
XXX

      A
     A A
    A   A
   A     A
  A       A
 A         A
AAAAAAAAAAAAA


 */
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // flag 控制每个输出之间有空行，且最后一个输出后无空行
        int flag = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("@")) {
                break;
            }
            String c = s.split(" ")[0];
            int n = Integer.valueOf(s.split(" ")[1]);
            if (flag != 0) {
                System.out.println();
            }
            flag = 1;
            f(c, n);
        }
        sc.close();
    }
    
    public static void f(String c, int n) {
        if (n == 1) {
            System.out.println(c);
            return;
        }
        for (int j = 0; j < n - 1; j++) {
            System.out.print(" ");
        }
        System.out.println(c);
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            for (int j = 0; j < 2 * i - 3; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            System.out.println();
        }
        for (int j = 0; j < 2 * n - 1; j++) {
            System.out.print(c);
        }
        System.out.println();
    }
}