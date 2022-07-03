package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/7/2 11:22 AM
 */
public class jz33 {
    public static void main(String[] args) {
        System.out.println(new jz33().verifyPostorder(new int[]{1, 5, 2, 4, 3}));
    }

    /*
             1,2,5,10,6,9,4,3

     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }


    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start == end) {
            return true;
        }
        int root = postorder[end];
        int leftStart = -1;
        int leftEnd = -1;
        int rightStart = -1;
        int rightEnd = -1;
        for (int i = start; i < end; i++) {
            if (postorder[i] < root) {
                if (rightStart != -1) {
                    return false;
                }
                if (leftStart == -1) {
                    leftStart = i;
                }
                leftEnd = i;
            } else {
                if (rightStart == -1) {
                    rightStart = i;
                }
                rightEnd = i;
            }
        }
        return (leftStart == -1 || verifyPostorder(postorder, leftStart, leftEnd)) && (rightEnd == -1 || verifyPostorder(postorder, rightStart, rightEnd));
    }
}
