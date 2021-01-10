package com.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author kkllor
 * @date 2021/1/7 8:58 AM
 */
public class lc39 {
    private List<List<Integer>> resetSet = new ArrayList();

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7};
        lc39 lc39 = new lc39();
        lc39.findSolution(11, array, new ArrayList<>(), 0);
        System.out.println(lc39.resetSet);

    }

    //
    private void findSolution(int target, int[] array, List<Integer> solution, int start) {
        if (target == 0) {
            resetSet.add(new ArrayList<>(solution));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < array.length; i++) {
            solution.add(array[i]);
            findSolution(target - array[i], array, solution, i);
            solution.remove(new Integer(array[i]));
        }

    }

}
