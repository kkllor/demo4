package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/29 1:25 PM
 */
public class FindKth {

    /**
     * 3,5,2,7,8,4,6,9,1
     * <p>
     * n=9 k=4
     * <p>
     * 3,5,2,7,8,4,6,9
     * <p>
     * n=8
     * k=3
     * <p>
     * 3,5,2,7,8,4,6
     * n=7
     * k=3
     * <p>
     * 3,5,2,4
     * n=4
     * k=3
     * <p>
     * 3,2,4,5
     *
     * @param a
     * @param n
     * @param K
     * @return
     */


    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKthInternal(a, 0, n - 1, n-K+1);
    }

    public int findKthInternal(int[] a, /*int n,*/ int start, int end, int K) {
        int partition = partition(a, start, end);
        if (partition == K - 1) {
            return a[partition];
        } else if (partition > K - 1) {
            return findKthInternal(a, start, partition - 1, K);
        } else {
            return findKthInternal(a, partition + 1, end, K);
        }
    }

    private int partition(int[] a, int start, int end) {
        int target = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] <= target) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, end);
        return i;
    }

    private void swap(int[] a, int from, int to) {
        int tmp = a[from];
        a[from] = a[to];
        a[to] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(new FindKth().findKth(array, 49, 24));
    }
}
