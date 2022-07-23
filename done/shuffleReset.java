package done;

import java.util.Random;

public class shuffleReset {
    int[] nums;
    int[] original;

    public shuffleReset(int[] nums1) {
        nums = nums1;
        original = nums.clone();
    }

    public int[] reset() {
        nums = original;
        original = original.clone();
        return nums;
    }
//JDK   Collections.shuffle()方法
    public int[] shuffle() {
        int len = nums.length;
        Random rand = new Random(len);
        for (int i = len; i > 1; i--) {
            swap(i - 1, rand.nextInt(i));
        }
        return nums;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int n[] = { 1, 2, 3, 4, 5, 6, 7};
        shuffleReset s1 = new shuffleReset(n);

        int []nums1 = s1.shuffle();
        for (int i : nums1)
            System.out.print(i);
        System.out.println();

        int []nums2 = s1.reset();
        for (int i : nums2)
            System.out.print(i);
        System.out.println();

        int [] nums3 = s1.shuffle();
        for (int i : nums3)
            System.out.print(i);
        System.out.println();
    }
}
