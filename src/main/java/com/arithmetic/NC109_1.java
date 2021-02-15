package com.arithmetic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/2/13 3:36 PM
 */
public class NC109_1 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}
        };
        System.out.println(new NC109_1().solve(grid));
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code her
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid, int x, int y, int xLimit, int yLimit) {
        grid[x][y] = 0;
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            dfs(grid, x - 1, y, xLimit, yLimit);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            dfs(grid, x, y - 1, xLimit, yLimit);
        }
        if (x + 1 < xLimit && grid[x + 1][y] == '1') {
            dfs(grid, x + 1, y, xLimit, yLimit);
        }
        if (y + 1 < yLimit && grid[x][y + 1] == '1') {
            dfs(grid, x, y + 1, xLimit, yLimit);
        }
    }

}
