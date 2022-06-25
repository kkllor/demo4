package com.arithmetic.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/6/24 8:53 PM
 */
public class lc131 {
    private List<List<String>> result = new ArrayList<>();
    private int mark[][];

    public static void main(String[] args) {
//        "a","b","bab"
        try {
            System.out.println(new lc131().partition("abbab"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
bab


 */

    public List<List<String>> partition(String s) {
        mark = new int[s.length() + 1][s.length() + 1];
        solution(s, 0, s.length() - 1);
        return result;
    }

    public void solution(String s, int start, int end) {
        if (start == end) {
            List<String> list = new ArrayList<>();
            list.add(s.charAt(start) + "");
            result.add(list);
            return;
        }
        char c = s.charAt(start);
        solution(s, start + 1, end);
        List<List<String>> newResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i);
            boolean flag = true;
            int index = start + 1;
            for (String str : list) {
                if (!isPalindrome(s, index, index + str.length() - 1)) {
                    System.out.println(list + " is passed!");
                    flag = false;
                }
                index += str.length();
            }
            if (flag) {
                list.add(0, c + "");
                newResult.add(new ArrayList<>(list));
                list.remove(0);
            }

            String str = c + list.get(0);
            if (start == 0) {
                if (isPalindrome(s, start, start + str.length() - 1)) {
                    list.remove(0);
                    list.add(0, str);
                    newResult.add(new ArrayList<>(list));
                }
            } else {
                list.remove(0);
                list.add(0, str);
                newResult.add(new ArrayList<>(list));
            }
        }


        result = newResult;
    }

    public boolean isPalindrome(String s, int start, int end) {
        int originStart = start;
        int originEnd = end;
        try {
            if (mark[start][end] == 2) {
                return false;
            }
            if (mark[start][end] == 1) {
                return true;
            }

            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    mark[start][end] = 2;
                    return false;
                }
                start++;
                end--;
            }
            mark[originStart][originEnd] = 1;
            return true;
        } finally {
//            System.out.println(s.substring(originStart, originEnd + 1) + " = " + (mark[originStart][originEnd] == 1));
        }
    }
}
