package com.arithmetic.jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2022/6/18 8:54 AM
 */
//https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
public class jz05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("      " +
                ""));
    }

    public static String replaceSpace(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                queue.add('%');
                queue.add('2');
                queue.add('0');
            } else {
                queue.add(s.charAt(i));
            }
        }
        if (queue.isEmpty()) {
            return s;
        }
        char[] replacedArray = new char[queue.size()];
        for (int i = 0; i < replacedArray.length; i++) {
            replacedArray[i] = queue.poll();
        }
        return new String(replacedArray);
    }
}
