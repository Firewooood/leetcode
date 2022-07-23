package done;public class findRelativeRanks {
    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        findRelativeRanks f1 = new findRelativeRanks();
        String[] res = f1.f1(score);
        for (String s : res) {
            System.out.println(s);
        }
    }
    
    public String[] f1(int[] score) {
        int len = score.length;
        String[] res = new String [len];
        int [] grade = new int [len];
        for (int i = 0; i < len; i++) {
            grade[i] = len;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (score[i] > score[j])
                    grade[i]--;
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(grade[i]);
            switch(grade[i]){
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = String.format("%d", grade[i]);
            }
            
        }
        return res;
    }
}
