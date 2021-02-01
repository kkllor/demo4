package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/30 9:40 PM
 */
public class NC1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        int pre = 0;
        int currentIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (s.length() > currentIndex || t.length() > currentIndex) {
            int sum = getValue(s, currentIndex) + getValue(t, currentIndex) + pre;
            stringBuilder.insert(0, sum % 10);
            pre = sum / 10;
            currentIndex++;
        }
        if (pre != 0) {
            stringBuilder.insert(0, pre);
        }
        return stringBuilder.toString();
    }

    private int getValue(String target, int index) {
        if (index >= target.length()) {
            return 0;
        }
        return Integer.valueOf(target.charAt(target.length() - 1 - index) + "");
    }


    public static void main(String[] args) {
        System.out.println(new NC1().solve("999", "1"));
    }
}
