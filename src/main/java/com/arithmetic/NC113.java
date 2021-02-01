package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/24 10:21 PM
 */
public class NC113 {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,5,6,7};
        System.out.println(new NC113().solve(array));
    }

    public int solve(int[] a) {
        // write code here
        return find(a, 0, a.length-1);
    }

    private int find(int[] a, int start, int end) {
        if (start >= end) {
            if (a[start] > start) {
                return start;
            }
            if (a[start] == start) {
                return start + 1;
            }
        }
        int mid = start + (end - start >> 1);
        if (a[mid] == mid) {
            return find(a, mid + 1, end);
        } else {
            return find(a, start, mid - 1);
        }
    }

}
