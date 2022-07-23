package done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isNStraighthand {
    public static void main(String[] args) {
        isNStraighthand i1 = new isNStraighthand();
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(i1.is1(hand, 3));
    }
    // Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，
    // 使每一组的牌数都是 groupSize，
    // 并且由 groupSize 张连续的牌组成。

    // 给你一个整数数组 hand 其中 hand[i]
    // 是写在第 i 张牌，
    // 和一个整数 groupSize。如果她可能重新排列这些牌，返回 true；否则，返回 false。
    public boolean is1(int[] hand, int groupSize) {
        int len = hand.length;
        Map<Integer,Integer> map = new HashMap<>();
        if (len % groupSize != 0)
            return false;
        //将hand数组排序
        Arrays.sort(hand);
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            //将已使用过的点标注为-1。遍历时直接步过
            //从起始点开始步过后groupSize个点
            if (map.get(hand[i]) == 0)
                continue;
            for (int j = 0; j < groupSize; j++) {
                //若不包含该值，则直接返回false
                if(!map.containsKey(hand[i]+j)||map.get(hand[i]+j)==0)
                    return false;
                map.put(hand[i]+j, map.get(hand[i]+j)-1);
                }
            }   
                return true;
        }


    }
