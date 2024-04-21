package 笔试真题;

import java.util.Scanner;

/**
 * 小美的朋友关系
 * 
小美认为，在人际交往中，但是随着时间的流逝，朋友的关系也是会慢慢变淡的，最终朋友关系就淡忘了。
现在初始有一些朋友关系，存在一些事件会导致两个人淡忘了他们的朋友关系。小美想知道某一时刻中，
某两人是否可以通过朋友介绍互相认识？

事件共有 2 种：
1 u v：代表编号 u 的人和编号 v 的人淡忘了他们的朋友关系。
2 u v：代表小美查询编号 u 的人和编号 v 的人是否能通过朋友介绍互相认识。
注：介绍可以有多层，比如 2 号把 1 号介绍给 3 号，然后 3 号再把 1 号介绍给 4 号，这样 1 号和 4 号就认识了

输入描述：
第一行输入三个正整数n,m,q，代表总人数，初始的朋友关系数量，发生的事件数量。
接下来的m行，每行输入两个正整数u,v，代表初始编号u的人和编号v的人是朋友关系。
接下来的q行，每行输入三个正整数op,u,v，含义如题目描述所述。
1<=n <= 10^9
1<= m,q<= 10^5
1<= u,v<= n
1<= op <= 2
保证至少存在一次查询操作。

输出描述
对于每次 2 号操作，输出一行字符串代表查询的答案。如果编号 u 的人和编号 v 的人能通过朋友介绍互相认识，则输出"Yes"。否则输出"No"。

样例输入：
5 3 5
1 2
2 3
4 5
1 1 5
2 1 3
2 1 4
1 1 2
2 1 3

样例输出：
Yes
No
No

说明
第一次事件，1 号和 5 号本来就不是朋友，所以无事发生。
第二次事件是询问，1 号和 3 号可以通过 2 号的介绍认识。
第三次事件是询问，显然 1 号和 4 号无法互相认识。
第四次事件，1 号和 2 号淡忘了。
第五次事件，此时 1 号无法再经过 2 号和 3 号互相认识了。

 */
import java.util.*;
public class Test240309美团5 {
    static HashMap<Integer, Integer> father = new HashMap<>();

    static int find(int x) {
        return father.get(x) == x ? x : find(father.get(x));
    }

    static void merge(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i != j) {
            father.put(i, j);
        }
    }

    static class Node {
        int op;
        int u;
        int v;

        Node(int op, int u, int v) {
            this.op = op;
            this.u = u;
            this.v = v;
        }
    }

    // 并查集不方便删除
    // 逆向思维，找出所有可能要删除的边，假设所有边都删除了，构建一个新的最终的并查集
    // 逆向遍历所有的q次操作，如果是查询，使用并查集直接查出即可；如果是删除(2操作)，则往并查集添加边。

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        List<Node> all = new ArrayList<>();
        Set<List<Integer>> q = new HashSet<>();
        Set<List<Integer>> q_del = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            father.put(u, u);
            father.put(v, v);
            List<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
            q.add(edge);
        }

        List<Node> a = new ArrayList<>();
        int add = 0;
        for (int i = 0; i < p; i++) {
            int op = scanner.nextInt();
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            father.put(u, u);
            father.put(v, v);

            if (op == 1) {
                List<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                if (q.contains(edge)) {
                    q_del.add(edge);
                } else {
                    Collections.reverse(edge);
                    if (q.contains(edge)) {
                        q_del.add(edge);
                    } else {
                        continue;
                    }
                }
            }
            all.add(new Node(op, u, v));
        }

        for (List<Integer> e : q_del) {
            int u = e.get(0);
            int v = e.get(1);
            if (q.contains(Arrays.asList(u, v)) || q.contains(Arrays.asList(v, u))) {
                q.remove(e);
            }
        }

        for (List<Integer> e : q) {
            merge(e.get(0), e.get(1));
        }

        List<String> res = new ArrayList<>();
        for (int i = add - 1; i >= 0; i--) {
            if (a.get(i).op == 1) {
                merge(a.get(i).u, a.get(i).v);
            } else {
                if (find(a.get(i).u) == find(a.get(i).v)) {
                    res.add("Yes");
                } else {
                    res.add("No");
                }
            }
        }

        Collections.reverse(res);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
