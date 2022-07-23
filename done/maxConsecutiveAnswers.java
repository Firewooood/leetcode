package done;
public class maxConsecutiveAnswers {
    public static void main(String[] args) {
        maxConsecutiveAnswers m1 = new maxConsecutiveAnswers();
        System.out.println(m1.maxConsecutiveAnswers1("F", 1));
    }
    
    public int maxConsecutiveAnswers1(String answerKey, int k) {
        int max = 0;
        int start = 0, end = 0, k1 = k;// 定义双指针，指向滑动窗口的边界
        while (end < answerKey.length()) {// 最大连续为F的情况
            if (k > 0){
                if (answerKey.charAt(end) == 'F') {
                    max = Math.max(max, end - start + 1);
                    end++;
                }
                else{
                    end++;k--;
                }
            } else {
                //此时出现已无法 改T为F
                if (answerKey.charAt(end) == 'F') {
                    max = Math.max(max, end - start + 1);
                    end++;
                } else {
                    max = Math.max(max, end - start);
                    if (answerKey.charAt(start) == 'T')
                        k++;
                    start++;
                }
            }   
        }
        start = 0;
        end = 0;
        k = k1;
        while (end < answerKey.length()) {// 最大连续为T的情况
            if (k > 0) {
                if (answerKey.charAt(end) == 'T') {
                    max = Math.max(max, end - start + 1);
                    end++;
                } else {
                    end++;
                    k--;
                }
            } else {
                // 此时出现已无法 改F为T
                if (answerKey.charAt(end) == 'T') {
                    max = Math.max(max, end - start + 1);
                    end++;
                } else {
                    max = Math.max(max, end - start);
                    if (answerKey.charAt(start) == 'F')
                        k++;
                    start++;
                }
            }
        }
        return max;
    }
}
