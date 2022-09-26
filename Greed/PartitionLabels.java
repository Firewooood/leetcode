package Greed;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    /**
     * 最多能砍s多少刀？使得同一字母都出现在一个片段，且片段最多
     * 
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] map = new int[26]; // map[i] 表示字母i出现在字符串中的最后一个位置
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        char cur = 'a';
        int range = 0, pre = -1; // 表示片段的右坐标
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (map[cur - 'a'] > range) {
                range = map[cur - 'a']; // 更新当前片段的右坐标
            }
            if (range == i) {
                res.add(range - pre);
                pre = range;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p1 = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = p1.partitionLabels(s);
    }
}
