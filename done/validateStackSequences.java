package done;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class validateStackSequences {
    public static void main(String[] args) {
        validateStackSequences v1 = new validateStackSequences();
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 5,4,3,2,1 };
        System.out.println(v1.validateStackSequences1(pushed, popped));
    }
    
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0)
            return true;
        int i = 0, j = 0; //使用i，j分别记录pushed和popped的下标
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        //当栈为空 或 已入栈的不包含下一出栈元素时
        while (j < pushed.length) {
            while (!set.contains(popped[j])) {
                stack.push(pushed[i]);
                set.add(pushed[i]);
                i++;  
            }
            if (popped[j] == stack.pop()) {
                set.remove(popped[j]);
                j++;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
}
