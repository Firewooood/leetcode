package done;public class bulbSwitch {
    public static void main(String[] args) {

    }

    /*
     * 第 ii 轮改变所有编号为 ii 的倍数的灯泡的状态（其中灯泡编号从 11 开始）。
     * 
     * 一个编号为 xx 的灯泡经过 nn 轮后处于打开状态的充要条件为 
     * 「该灯泡被切换状态次数为奇数次」。 
     * 同时，一个灯泡切换状态的次数为其约数的个数（去重）。
     * 
     * 于是问题转换为：在 [1,n] 内有多少个数，其约数的个数为奇数。
     * 这些约数个数为奇数的灯泡就是最后亮着的灯泡。
     * 
     */
    public int b1(int n) {

        return (int) Math.sqrt(n);
    }
}
