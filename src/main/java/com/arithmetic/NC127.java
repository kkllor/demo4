package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/13 3:07 PM
 */
public class NC127 {

    public static void main(String[] args) {
        System.out.println(new NC127().LCS("1AB2345EFCD", "12345EF"));
    }

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int end = 0;
        int max = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < str2.length() + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        end = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if (max == 0) {
            return "-1";
        }

        return str1.substring(end - max, end);
    }
}
