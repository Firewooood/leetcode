package done;
public class printNumbers {
    public static void main(String[] args) {
        // int[] res = printNumbers1(1);
        // for(int x:res)
        //     System.out.println(x);

        //要在此处使用内部类中的函数
        //需要捕获一个外部类的实例
        printNumbers p1 = new printNumbers();
        printNumbers.Solution solution = p1.new Solution();
        String res = solution.printNumbers(2);
        System.out.println(res);

    }

    public static int[] printNumbers1(int n) {
        if (n > 9)
            return new int[0];
        int num = (int) Math.pow(10, n) - 1;
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i + 1;
        }

        return res;
    }
    
    
    class Solution {
        StringBuilder res;
        int count = 0, n;
        char[] num, loop = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder();
            num = new char[n];//定义长度为n的字符列表
            dfs(0);//开启全排列
            res.deleteCharAt(res.length() - 1); //删除多余的逗号
            return res.toString(); //转化为字符串并返回
        }

        void dfs(int x) {
            if (x == n) {
                //定义终止条件：已固定完所有位
                res.append(String.valueOf(num) + ",");//拼接num至res尾部，使用逗号作为分隔
                return;
            }
            for (char i : loop) {
                num[x] = i;//固定第x位为i
                dfs(x + 1);
            }
        }
    }
}
