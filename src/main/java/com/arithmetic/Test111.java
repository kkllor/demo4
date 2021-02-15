package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/10 10:51 AM
 */
public class Test111 {

    public String LCS(String str1, String str2) {
        // write code here
        int len1 = str1.length(), len2 = str2.length();
        // dp[i][j]表示：str1中0~i，str2中0~j的字符串的最长公共子串长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0, endIndex = 0;
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        // 注意i和j在str中的是比实际位置多1的
        return maxLen == 0 ? "-1" : str1.substring(endIndex - maxLen, endIndex);
    }

    public static void main(String[] args) {
//        new Test111().LCS("1AB2345CD","12345EF");
        new Test111().LCS("1","12");
    }
}
