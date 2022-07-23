package done;
class translateNum {
    public static void main(String[] args) {
        translateNum t1 = new translateNum();
        System.out.println(t1.translate(12258));
    }
    
    public int translate(int num)
    {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for(int i = 1; i < str.length(); i++ )
        {
            if (str.charAt(i - 1) >= '3' || str.charAt(i - 1) == '0')
                dp[i + 1] = dp[i]; //若前一数字不为 1、 2，则前一字母和后一无组合
            else if (str.charAt(i - 1) == '2' || str.charAt(i - 1) == '1') {
                if (str.charAt(i) > '5' && str.charAt(i - 1) == '2')
                    dp[i + 1] = dp[i];
                else
                    dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[str.length()];
    }

}