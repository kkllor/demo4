package com.arithmetic.lc;

/**
 * @author kkllor
 * @date 2021/3/16 4:31 下午
 */
public class lc6 {
    public static void main(String[] args) {
        System.out.println(new lc6().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 0 || numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s.length());
        int n = 0;
        while (n < numRows && n < s.length()) {
            int start = n;
            while (start < s.length()) {
                stringBuilder.append(s.charAt(start));
                if (n != 0 && n != numRows - 1) {
                    int middleIndex = start + 2 * (numRows - n - 1);
                    if (middleIndex < s.length()) {
                        stringBuilder.append(s.charAt(middleIndex));
                    }
                }
                start += 2 * (numRows - 1);
            }
            n++;
        }
        return stringBuilder.toString();
    }

}
