package done;
import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence f1 = new findContinuousSequence();
        int[][] res = f1.find(100);
    }

    public int[][] find(int target) {
        List<int[]> list = new ArrayList<>();
        int dif = 1, i = 2; //i为此时数的个数
        while (dif < target) {
            if ((target - dif) < i)
                break;
            if ((target - dif) % i == 0) {//target可由i个连续的数表示
                int x = (target - dif) / i;
                int[] temp =  new int[i];
                for (int j = 0; j < i; j++) {
                    temp[j] = x + j;
                }
                list.add(temp);
            }
            dif += i;
            i++;
        }
        i = list.size() - 1;
        int[][] res = new int[list.size()][];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(i--);
        }
        return res;
    }
}
