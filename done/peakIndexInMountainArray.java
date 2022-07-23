package done;

public class peakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
        System.out.println(peakIndexInMountainArray1(arr));
    }
    
    public static int peakIndexInMountainArray1(int[] arr) {
        int len = arr.length;
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int j = i - 1;
            if (arr[i] > arr[j] && arr[i] > arr[i + 1]) {
                res = i;
                break;
            }
        }
        return res;
    }
    
     public static int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m1 = l + (r - l) / 3;
            int m2 = r - (r - l) / 3;
            if (arr[m1] > arr[m2]) r = m2 - 1;
            else l = m1 + 1;
        }
        return r;
    }
}
