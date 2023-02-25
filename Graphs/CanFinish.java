package Graphs;

import java.util.Stack;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] pre) {
        int[] need = new int[numCourses]; // 定义数组 need[i]  表示想要学习 i 需要先修的课程数
        boolean[] out = new boolean[numCourses]; // 表示当前元素是否已移除
        Stack<Integer> stack = new Stack<>();
        int outNum = 0;
        // 初始化邻接矩阵
        for (int i = 0; i < pre.length; i++) {
            need[pre[i][0]]++;
        }
        // 将入度为0的点加入栈中
        for (int i = 0; i < need.length; i++) {
            if (need[i] == 0 && !out[i]) {
                out[i] = true;
                stack.push(i);
                outNum++;
            }
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int i = 0; i < pre.length; i++) {
                if (pre[i][1] == cur)
                    need[pre[i][0]]--;
            }
            for (int i = 0; i < need.length; i++) {
                if (need[i] == 0 && !out[i]) {
                    out[i] = true;
                    stack.push(i);
                    outNum++;
                }
            }
                   
        }return outNum == numCourses;
    }
        
        
    

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 },{0,1} };
        CanFinish c1 = new CanFinish();
        System.out.println(c1.canFinish(numCourses, prerequisites));
    }
}
