package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/13 8:56 AM
 */
public class NC48 {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5,6};
        System.out.println(new NC48().search(A, 1));
    }

    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        // write code here
        return search(A, 0, A.length - 1, target);
    }

    public int search(int[] A, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start >> 1);
        if (A[mid] == target) {
            return mid;
        }
        //前半部分有序
        if (A[start] <= A[mid]) {
            if (target >= A[start] && target < A[mid]) {
                return search(A, start, mid - 1, target);
            } else {
                return search(A, mid + 1, end, target);
            }
        }
        //后半部分有序
        else {
            if (target > A[mid] && target <= A[end]) {
                return search(A, mid + 1, end, target);
            } else {
                return search(A, start, mid - 1, target);
            }
        }
    }
}
