package done;


import java.util.HashSet;
import java.util.Set;

public class singlenumber {
    public static void main(String[] args) {
        int[] nums = { -1, 0 };
        int[] res = f2(nums);
        for(int x:res)
        {
            System.out.println(x);
        }
    }

    /*给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 
    找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。*/
    public static int[] f1(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);//若集合中含x，则删除该x，降低空间复杂度
            } else {
                set.add(x);
            }
        }
        int i = 0;
        for (Integer x : set) {
            res[i++] = x.intValue();
        }
        return res;
    }     
    
    public static int[] f2(int[] nums){
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        //xorsum最后的值，为两个不同的数x1和x2的异或即x1⊕x2
        //x1⊕x2 某一位为1时，x1，x2在该位一个为1一个为0。
        //则nums中的所有数可分为两类，即第l位为0的一类 和第l位为1的一类
        //将两类中的所有数全部异或，则可得到x1和x2

        //防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[] { type1, type2 };
    }
    
}
