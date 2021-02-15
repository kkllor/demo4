package com.arithmetic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/2/13 3:36 PM
 */
public class NC109 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}
        };
        System.out.println(new NC109().solve(grid));
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        List<HashSet<Point>> islandList = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    addToIsland(i, j, islandList);
                }
            }
        }

        return islandList.size();
    }

    private void addToIsland(int x, int y, List<HashSet<Point>> islandList) {

        List<HashSet<Point>> containsList = new ArrayList<>();
        for (int index = 0; index < islandList.size(); index++) {
            HashSet<Point> island = islandList.get(index);
            boolean contains = false;
            //上
            if (x - 1 >= 0) {
                contains = island.contains(new Point(x - 1, y));
            }
            //左
            if (!contains && y - 1 >= 0) {
                contains = island.contains(new Point(x, y - 1));
            }
            if (contains) {
                containsList.add(island);
            }
        }

        if (containsList.isEmpty()) {
            HashSet<Point> island = new HashSet<>();
            island.add(new Point(x, y));
            islandList.add(island);
            return;
        }
        if (containsList.size() == 1) {
            containsList.get(0).add(new Point(x, y));
            return;
        }
        //合并
        if (containsList.size() > 1) {
            HashSet<Point> baseLand = containsList.get(0);
            baseLand.add(new Point(x, y));
            for (int i = 1; i < containsList.size(); i++) {
                baseLand.addAll(containsList.get(i));
            }

            Iterator<HashSet<Point>> iterator = islandList.iterator();
            while (iterator.hasNext()) {
                HashSet<Point> island = iterator.next();
                if (island != baseLand && containsList.contains(island)) {
                    iterator.remove();
                }
            }
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                return ((Point) obj).x == this.x && ((Point) obj).y == this.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x + y;
        }
    }
}
