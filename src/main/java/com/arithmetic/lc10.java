package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/10 5:11 PM
 */
public class lc10 {


    public static void main(String[] args) {
        isMatch("", "*");
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 1;
        for (int j = 1; j < p.length(); j++) {
            if (p.charAt(j - 1) != '*') continue;
            else dp[0][j] = dp[0][j - 2];
        }


        return false;
    }
}
