package com.arithmetic;

import apple.laf.JRSUIUtils;

/**
 * @author kkllor
 * @date 2021/1/21 3:19 PM
 */
public class TreeDiameter {

    public static void main(String[] args) {
        Interval[] Tree_edge = new Interval[5];
        Tree_edge[0] = new Interval(0, 1);
        Tree_edge[1] = new Interval(1, 5);
        Tree_edge[2] = new Interval(1, 2);
        Tree_edge[3] = new Interval(2, 3);
        Tree_edge[4] = new Interval(2, 4);
        int[] Edge_value = new int[5];
        Edge_value[0] = 3;
        Edge_value[1] = 4;
        Edge_value[2] = 2;
        Edge_value[3] = 1;
        Edge_value[4] = 5;
    }

    /**
     * 树的直径
     *
     * @param n          int整型 树的节点个数
     * @param Tree_edge  Interval类一维数组 树的边
     * @param Edge_value int整型一维数组 边的权值
     * @return int整型
     */
    public int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        // write code here
        return -1;
    }


    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

