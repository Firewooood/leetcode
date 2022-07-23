package done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class loudAndRich {
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
        loudAndRich l1 = new loudAndRich();
        int[] res = l1.loudAndRich1(richer, quiet);
        for(int x:res)
            System.out.println(x);
    }
    /**
     * 
     * @param richer richer[i] = [ai,bi], 表示person ai 比 person bi更有钱
     * @param quiet 表示i个人物的安静值
     * @return res res[x] = y 的前提是，在所有拥有的钱不少于personx的人中，person y 是最安静的人
     */
    public int[] loudAndRich1(int[][] richer, int[] quiet) {
        int num = quiet.length;//人数
        int[] in = new int[num];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] r : richer) {
            int a = r[0], b = r[1];
            //添加有钱至没钱的有向边
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
            in[b]++;   //当有a比b有钱时，b的入度++
        }
        Deque<Integer> d = new ArrayDeque<>();
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i; //初始化答案，
            //若有一点的入度为0，则将他加入队列
            if(in[i]==0)d.addLast(i);
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int u : map.getOrDefault(t, new ArrayList<>())) {
                if (quiet[res[t]] < quiet[res[u]])
                    res[u] = res[t];
                if (--in[u] == 0)
                    d.addLast(u);
            }
        }
        return res;
    }
}
