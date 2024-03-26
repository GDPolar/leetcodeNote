/**
 * 
题目描述
本题考察链表的基本操作。温馨提示：本题较为复杂，需要细心多花一些时间。

输入描述
输入数据只有一组，第一行有n+1个整数，第一个整数是这行余下的整数数目n，后面是n个整数。
这一行整数是用来初始化列表的，并且输入的顺序与列表中的顺序相反，也就是说如果列表中是1、2、3那么输入的顺序是3、2、1。
第二行有一个整数m，代表下面还有m行。每行有一个字符串，字符串是“get”，“insert”，“delete”，“show”中的一种。

如果是“get”，代表获得第a个元素。（a从1开始计数）
如果是“delete”，代表删除第a个元素。（a从1开始计数）
如果是“insert”，则其后跟着两个整数a和e，代表在第a个位置前面插入e。（a从1开始计数）
“show”之后没有正数，直接打印链表全部内容。

输出描述
如果获取成功，则输出该元素；
如果删除成功，则输出“delete OK”；
如果获取失败，则输出“get fail”
如果删除失败，则输出“delete fail”
如果插入成功，则输出“insert OK”，否则输出“insert fail”。
如果是“show”，则输出列表中的所有元素，如果列表是空的，则输出“Link list is empty”
注：所有的双引号均不输出。

输入示例
3 3 2 1
21
show
delete 1
show
delete 2
show
delete 1
show
delete 2
insert 2 5
show
insert 1 5
show
insert 1 7
show
insert 2 5
show
insert 3 6
show
insert 1 8
show
get 2

输出示例
1 2 3
delete OK
2 3
delete OK
2
delete OK
Link list is empty
delete fail
insert fail
Link list is empty
insert OK
5
insert OK
7 5
insert OK
7 5 5
insert OK
7 5 6 5
insert OK
8 7 5 6 5
7

提示信息
初始化链表的元素是倒序的，这个使用题目中创建列表的方法（从头部插入）就可以了。
 */
import java.util.*;

public class Main {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            while (n-- > 0) {
                list.addFirst(sc.nextInt());
            }
            int m = sc.nextInt();
            sc.nextLine();
            while (m-- > 0) {
                String s = sc.nextLine();
                String[] com = s.split(" ");
                if (s.equals("show")) {
                    show(list);
                } else if (com[0].equals("get")) {
                    get(list, Integer.valueOf(com[1]));
                } else if (com[0].equals("delete")) {
                    delete(list, Integer.valueOf(com[1]));
                } else {
                    insert(list, Integer.valueOf(com[1]), Integer.valueOf(com[2]));
                }
            }
        }
        sc.close();
    }
    
    public static void show(LinkedList<Integer> list) {
        if (list.size() == 0) {
            System.out.println("Link list is empty");
            return;
        }
        int j = 1;
        for (Integer i : list) {
            System.out.print(i);
            if (j++ < list.size()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public static void get(LinkedList<Integer> list, int index) {
        if (index <= 0 || index > list.size()) {
            System.out.println("get fail");
            return;
        }
        Integer res = list.get(index - 1);
        System.out.println(res);
    }
    
    public static void delete(LinkedList<Integer> list, int index) {
        if (index <= 0 || index > list.size()) {
            System.out.println("delete fail");
            return;
        }
        list.remove(index - 1);
        System.out.println("delete OK");
    }
    public static void insert(LinkedList<Integer> list, int index, int value) {
        if (index <= 0 || index > list.size() + 1) {
            System.out.println("insert fail");
            return;
        }
        list.add(index - 1, value);
        System.out.println("insert OK");
        
    }
}