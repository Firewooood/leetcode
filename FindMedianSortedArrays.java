public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        boolean isOdd = (m + n) % 2 == 1 ? true : false;
        int p1 = -1, p2 = -1;
        int i1 = 0, i2 = 0;
        double res = 0;
        for (int i = 0; i <= (m + n) / 2; i++) {
            p1 = p2;
            if (i2 < n && (i1 >= m || nums1[i1] > nums2[i2])) {
                p2 = nums2[i2++];
            } else {
                p2 = nums1[i1++];
            }
        }
        if (isOdd)
            res = p2;
        else
            res = (p1 + p2) / 2.0;

        return res;
    }
    public static void main(String[] args) {
        FindMedianSortedArrays f1 = new FindMedianSortedArrays();
        int[] nums1 = { 2 }, nums2 = {};
        System.out.println(f1.findMedianSortedArrays(nums1, nums2));

    }
}
