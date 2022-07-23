package HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]))
                list.add(nums2[i]);
            set.remove(nums2[i]);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        Intersection i1 = new Intersection();
        int[] res = i1.intersection(nums1, nums2);
        for (int x : res)
            System.out.print(x + " ");
    }
}
