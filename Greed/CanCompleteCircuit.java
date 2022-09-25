package Greed;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        for (int x : gas)
            gasSum += x;
        for (int x : cost)
            costSum += x;
        if (gasSum < costSum)
            return -1; // 总汽油数少于总消耗，返回-1

        int len = gas.length;
        int start = 0, end = 0, cur = gas[0]; // 从开头开始
        while ((end + 1) % len != start) { // 当可以走到起点前一站，则必然可以到达起点 (gasSum >= costSum)
            if (cur > cost[end % len]) {
                cur += gas[(end + 1) % len] - cost[end % len]; // 更新当前汽车中汽油数
                end++;
            } else {
                start = ++end;
                cur = gas[start % len];
            }
        }

        return (end + 1) % len == start ? start : -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuit c1 = new CanCompleteCircuit();
        int[] gas = { 5, 8, 2, 8 }, cost = { 6, 5, 6, 6 };
        System.out.println(c1.canCompleteCircuit(gas, cost));
    }
}
