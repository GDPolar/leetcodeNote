/**
 * 
题目描述
小明发现和小宇有共同祖先！现在小明想知道小宇是他的长辈，晚辈，还是兄弟。

输入描述
输入包含多组测试数据。每组首先输入一个整数N（N<=10），接下来N行，每行输入两个整数a和b，表示a的父亲是b（1<=a,b<=20）。小明的编号为1，小宇的编号为2。
输入数据保证每个人只有一个父亲。

输出描述
对于每组输入，如果小宇是小明的晚辈，则输出“You are my younger”，如果小宇是小明的长辈，则输出“You are my elder”，如果是同辈则输出“You are my brother”。

输入示例
5
1 3
2 4
3 5
4 6
5 6
6
1 3
2 4
3 5
4 6
5 7
6 7

输出示例
You are my elder
You are my brother


 */
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[30];
            while(N -- > 0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a] = b;
            }
            int deep1 = 0;
            int deep2 = 0;
            int f1 = 1;
            int f2 = 2;
            while(arr[f1] != 0){
                deep1++;
                f1 = arr[f1];
            }
            while(arr[f2] != 0){
                deep2++;
                f2 = arr[f2];
            }
            if(deep1 == deep2){
                System.out.println("You are my brother");
            }else if(deep1 > deep2){
                System.out.println("You are my elder");
            }else{
                System.out.println("You are my younger");
            }
        }
        sc.close();
    }
}

