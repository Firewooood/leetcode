package Greed;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    /**
     * 
     * @param people people[i] = [hi, ki] hi为第i个人的身高，前面正好有ki个身高大于或等于hi的人
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 将people数组按照身高从大到小排序，若身高相同，ki较小的在前
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p); // 因为身高从大到小排，则后续插入的元素，不会影响之前的相对大小
        }

        return list.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        // out [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        ReconstructQueue r1 = new ReconstructQueue();
        int[][] res = r1.reconstructQueue(people);
        for (int i = 0; i < res.length; i++) {
            for (int x : res[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
