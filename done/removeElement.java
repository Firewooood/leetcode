package done;

public class removeElement {
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = 0;
        for (; i < len; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        removeElement r1 = new removeElement();
        System.out.println(r1.removeElement1(nums, 3));
    }
}
