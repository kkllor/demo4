package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/7/6 9:42 PM
 */
public class jz48 {
    /*
    abcadebb
     */
    public static void main(String[] args) {
        jz48 o = new jz48();
        System.out.println(o.lengthOfLongestSubstring("aaartyaaa"));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxCount = 1;
        int sum = 1;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            int index = contains(s, s.charAt(i), start, i - 1);
            if (index == -1) {
                sum++;
                maxCount = Math.max(sum, maxCount);
            } else {
                sum = i - index;
                start = index + 1;
            }
        }
        return maxCount;
    }

    private int contains(String s, char target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
