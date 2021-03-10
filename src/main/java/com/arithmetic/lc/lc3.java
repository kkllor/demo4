package com.arithmetic.lc;

/**
 * @author kkllor
 * @date 2021/3/9 2:57 下午
 */
public class lc3 {

    public int lengthOfLongestSubstring(String s) {
        //"pwwkew"
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            //计算以 s[i] 结尾的字串，最大不重复长度
            int index = findIndex(s, start, end, i);
            if (index > -1) {
                start = index + 1;
            }
            end = i;
            int l = (end - start + 1);
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

    private int findIndex(String s, int start, int end, int index) {
        char c = s.charAt(index);
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new lc3().lengthOfLongestSubstring("a"));
    }
}
