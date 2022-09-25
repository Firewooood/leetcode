package Greed;

import java.util.Arrays;

public class JargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (a, b) -> Math.abs(a) - Math.abs(b));
        int res = 0;
        for (int i = integers.length - 1; i >= 0; i--) {
            if (k == 0)
                break;
            if (integers[i] < 0) {
                integers[i] = -1 * integers[i];
                k--;
            }
        }
        for (int i = 0; i < integers.length; i++) {
            if (i == 0) {
                if (k % 2 == 0) {
                    res += integers[i];
                } else {
                    res -= integers[i];
                }
            } else {
                res += integers[i];
            }

        }

        return res;
    }

    public static void main(String[] args) {
        JargestSumAfterKNegations j1 = new JargestSumAfterKNegations();
        int[] nums = { 2, -3, -1, 5, -4 };
        System.out.println(j1.largestSumAfterKNegations(nums, 2));
    }
}
