package com.arithmetic.lc;

import java.util.*;

/**
 * @author kkllor
 * @date 2022/7/11 8:15 PM
 */
public class lc22 {
    /*
[()]
[(()) ()()]
[((( ))) (()()) (())()  ()(()) ()()() ]


()((()))

     */
    public static void main(String[] args) {
        try {
            lc22 lc22 = new lc22();
            List<String> result = lc22.generateParenthesis(3);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    StringBuilder stringBuilder = new StringBuilder();
    //    Stack<Character> stack = new Stack<>();
    private List<String> set = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solution(n, 0, 0, new StringBuilder());
        return new ArrayList<>(set);
    }

    public void solution(int n, int index, int leftCount, StringBuilder preStr) {
        if (n == index) {
            while (leftCount != 0) {
                leftCount--;
                preStr.append(')');
            }
            if(set.contains(preStr.toString())){
                return;
            }
            set.add(preStr.toString());
            return;
        }
        preStr.append('(');
        leftCount++;
        while (leftCount >= 0) {
            int sIndex = preStr.length();
            solution(n, index + 1, leftCount, preStr);
            preStr.delete(sIndex,preStr.length());
            preStr.append(')');
            leftCount--;
        }
    }
}
