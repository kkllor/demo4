package com.arithmetic.lc;

/**
 * @author kkllor
 * @date 2021/3/11 2:17 下午
 */
public class lc5 {

    //    输入：s = "babad"
//    输出："babbab"
//    解释："aba" 同样是符合题意的答案。
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int length = s.length();
        int maxLength = 1, maxStart = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j + 1 <= maxLength) {
                    break;
                }
                if (isPalindrome(s, j, i)) {
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        maxStart = j;
                    }
                    break;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new lc5().longestPalindrome("bbbb"));
    }
}
