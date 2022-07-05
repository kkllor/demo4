package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/7/4 9:57 PM
 */
public class TestRank {

    public static void main(String[] args) {
        TestRank testRank = new TestRank();
        testRank.rank("abcc");
        System.out.println(testRank.result);
    }

    private List<String> result = new ArrayList<>();

    public void rank(String s) {
        rank(s.toCharArray(), 0);
    }

    public void rank(char[] array, int start) {
        if (start == array.length) {
            result.add(new String(array));
            return;
        }

        for (int i = start; i < array.length; i++) {
            if (hasDuplicate(array, start, i - 1, array[i])) continue;
            swap(array, start, i);
            rank(array, start + 1);
            swap(array, start, i);
        }
    }

    private boolean hasDuplicate(char[] array, int from, int end, int target) {
        for (int i = from; i <= end; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }

    private void swap(char[] array, int from, int to) {
        if (from == to) {
            return;
        }
        char tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
