/**
 
题目描述
每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。

输入描述
有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。

输出描述
每组输出结果占一行。如果输入的大写字母都在集合｛A,B,C,D,F｝中，则输出对应的平均绩点，结果保留两位小数。否则，输出“Unknown”。

输入示例
A B C D F
B F F C C A
D C E F

输出示例
2.00
1.83
Unknown

 */

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        outer:
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] levels = line.split(" ");
            double sum = 0.0D;
            for (String s : levels) {
                if (s.equals("A")) {
                    sum += 4.0D;
                } else if (s.equals("B")) {
                    sum += 3.0D;
                } else if (s.equals("C")) {
                    sum += 2.0D;
                } else if (s.equals("D")) {
                    sum += 1.0D;
                } else if (s.equals("F")) {
                     
                } else {
                    System.out.println("Unknown");
                    continue outer;
                }
            }
            System.out.printf("%.2f\n", sum / levels.length);
            
        }
        sc.close();
    }
}