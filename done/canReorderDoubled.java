package done;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class canReorderDoubled {
    public static void main(String[] args) {
        canReorderDoubled c1 = new canReorderDoubled();
        int[] arr = { -6,-3 };
        System.out.println(c1.canReorderDoubled1(arr));
    }
    
    public boolean canReorderDoubled1(int[] arr) {
        int len = arr.length , zero = len;
        Map <Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int cur = arr[i];
            if (cur < 0) {
                // key存当前的数，value存它的倍数
                if (!map.containsKey(cur * 2)) { //若没有该数的2倍
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {//若有，则消去这一对数
                    map.put(cur * 2, map.get(cur * 2) - 1);
                    if (map.get(cur * 2) == 0)
                        map.remove(cur * 2);
                }
            }
            else{zero = i;break;}
        }
        for (int j = len - 1; j >= zero;j--)
            {
                int cur = arr[j];
                if (!map.containsKey(cur * 2)) { // 若没有该数的1/2
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {// 若有，则消去这一对数
                    map.put(cur * 2, map.get(cur * 2) - 1);
                    if (map.get(cur *2) == 0)
                        map.remove(cur * 2);
                }
            }
        if (map.size() == 0)
            return true;
        else
            return false;
    }
}
