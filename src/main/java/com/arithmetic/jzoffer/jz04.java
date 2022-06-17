package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/17 1:47 PM
 */

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * <p>
 * <p>
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jz04 {
    public static void main(String[] args) {
        try {
            int[][] matrix = new int[][]{
                    {1,  4,  7,  11, 15},
                    {2,  5,  8,  12, 19},
                    {3,  6,  9,  16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}};
            System.out.println(findNumberIn2DArray(matrix, 20));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        return containsNumber(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    public static boolean containsNumber(int[][] matrix, int startX, int endX, int startY, int endY, int target) {
        if(startX>endX || startY>endY){
            return false;
        }
        if (matrix[startX][startY] == target) {
            return true;
        }
        if (matrix[endX][endY] == target) {
            return true;
        }

        if (matrix[startX][startY] > target) {
            return false;
        }

        if (matrix[endX][endY] < target) {
            return false;
        }

        return containsNumber(matrix, startX, (startX + endX) / 2, startY, (startY + endY) / 2, target)
                || containsNumber(matrix, (startX + endX) / 2 + 1, endX, startY, (startY + endY) / 2, target)
                || containsNumber(matrix, startX, (startX + endX) / 2, (startY + endY) / 2 + 1, endY, target)
                || containsNumber(matrix, (startX + endX) / 2 + 1, endX, (startY + endY) / 2 + 1, endY, target);

    }

}
