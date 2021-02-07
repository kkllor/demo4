package com.arithmetic;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/2/7 4:22 PM
 */
public class NC52 {
    public static void main(String[] args) {
        System.out.println(new NC52().isValid1("){}{}"));
    }


//    给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
//    括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        Stack<Character> tmpStack = new Stack<>();

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (tmpStack.isEmpty()) {
                tmpStack.push(c);
            } else {
                char c1 = tmpStack.peek();
                if (isMatch(c, c1)) {
                    tmpStack.pop();
                } else {
                    tmpStack.push(c);
                }
            }
        }
        return tmpStack.isEmpty();
    }


    //    给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
//    括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

    /**
     * {()}[]
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid1(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    private boolean isMatch(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        }
        if (c1 == '[') {
            return c2 == ']';
        }
        if (c1 == '{') {
            return c2 == '}';
        }
        return false;
    }
}
