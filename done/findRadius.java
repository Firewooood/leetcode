package done;
import java.util.Arrays;

public class findRadius {
/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 */
    public static void main(String[] args) {
        findRadius f1 = new findRadius();
        int[] houses = { 1, 2, 3, 4 };
        int[] heaters = { 1, 4 };
        System.out.println(f1.f2(houses, heaters));

    }
    
    public int f1(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        //对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
        //对于所有的房屋，选择最大的上述距离。
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            //房屋没有前暖气
            if (houses[i] <= heaters[0]) {
                min = heaters[0] - houses[i];
            }
            //房屋没有后暖气
            else if (houses[i] >= heaters[m - 1]) {
                min = houses[i] - heaters[m - 1];
            } else {
                int low = 0, high = m - 1;//从heaters前后夹逼，求出houses的前后暖气位置]
                while (low < high) {
                    int mid = (low + high) >> 1;
                    if (heaters[mid] < houses[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                min = Math.min(heaters[low] - houses[i], houses[i] - heaters[low - 1]);
            }
            res = Math.max(res, min);
        }
        return res;
    }
    
    public int f2(int[] houses, int[] heaters) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            while (j < heaters.length && heaters[j] < houses[i])
                j++;
            //房子前方没供热点
            if(j==0)
                min = heaters[0] - houses[i];
            //房子后方没供热点
            else if (j == heaters.length) {
                min = houses[i] - heaters[j - 1];
            }
            //房子前后都有供热点的情况
            else {
                min = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
            }
            res = Math.max(res, min);
        }
        return res;
    }
}
