package com.arithmetic.lc;

/**
 * @author kkllor
 * @date 2021/3/9 3:42 下午
 */
public class lc4 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = 0;
        if (nums1.length > 0) {
            k += nums1.length;
        }
        if (nums2.length > 0) {
            k += nums2.length;
        }

        if (k % 2 == 1) {
            k = k / 2 + 1;
            return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
        } else {
            k = k / 2;
            return (findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k) + findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k + 1)) / 2.0;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

        while (start1 <= end1 || start2 <= end2) {
            if (start1 > end1) {
                return nums2[start2 + k - 1];
            }
            if (start2 > end2) {
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int halfIndex = k / 2;
            boolean isODD = k % 2 == 1;
            boolean n1Beyond = false, n2Beyond = false;
            int n1, n2;
            if (start1 + halfIndex - 1 > end1) {
                n1Beyond = true;
                n1 = nums1[end1];
            } else {
                n1 = nums1[start1 + halfIndex - 1];
            }

            if (start2 + halfIndex - 1 > end2) {
                n2Beyond = true;
                n2 = nums2[end2];
            } else {
                n2 = nums2[start2 + halfIndex - 1];
            }
            if (n1 == n2) {
                if (n1Beyond || n2Beyond) {
                    if (n1Beyond) {
                        k -= (end1 - start1 + 1);
                        start1 += halfIndex;
                    }
                    if (n2Beyond) {
                        k -= (end2 - start2 + 1);
                        start2 += halfIndex;
                    }
                } else {
                    if (!isODD) {
                        return n1;
                    } else {
                        k = 1;
                        start1 += halfIndex;
                        start2 += halfIndex;
                    }
                }
            } else if (n1 > n2) {
                if (n2Beyond) {
                    k -= (end2 - start2 + 1);
                } else {
                    k -= halfIndex;
                }
                start2 += halfIndex;
            } else {
                if (n1Beyond) {
                    k -= (end1 - start1 + 1);
                } else {
                    k -= halfIndex;
                }
                start1 += halfIndex;
            }
        }
        return -1;
    }

    private double getMidValue(int[] num, int start, int end, boolean calculateAverage) {
        int length = end - start + 1;
        if (length % 2 == 1) {
            return num[start + length / 2];
        } else {
            if (calculateAverage) {
                return (num[start + length / 2 - 1] + num[start + length / 2]) / 2.0;
            } else {
                return num[start + length / 2 - 1];
            }
        }
    }

    public static void main(String[] args) {

//        [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22]
//[0,6]

        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        int[] array2 = new int[]{0, 6};

        // 0 1 2 3 4 5 6 6 7 8 9 10 11,12,13,14,15,16,17,18,19,20,21,22
        // 10 11
        System.out.println(new lc4().findMedianSortedArrays(array1, array2));
    }
}
