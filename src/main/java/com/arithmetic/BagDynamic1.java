package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/27 4:50 PM
 */
public class BagDynamic1 {
    private int w = 7; // 背包承受的最大重量
    private int[] items = {2, 2, 7, 6, 3, 7}; // 物品的重量
    private int[] value = {3, 4, 88, 9, 6, 88}; // 物品的价值

    public static void main(String[] args) {
        new BagDynamic1().solution1();
    }

    //在满足背包重量的情况下，得到最大价值
    public void solution1() {
        int[][] state = new int[items.length][w + 1];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                state[i][j] = -1;
            }
        }
        //第一个物品没选择
        state[0][0] = 0;
        //第一个物品选择
        state[0][items[0]] = value[0];
        for (int i = 1; i < items.length; i++) {
            //第i个物品没选择
            for (int j = 0; j < w + 1; j++) {
                if (state[i - 1][j] > -1) {
                    state[i][j] = state[i - 1][j];
                }
            }
            //第i个物品选择
            for (int j = 0; j <= w - items[i]; j++) {
                if (state[i - 1][j] > -1) {
                    if (state[i - 1][j] + value[i] > state[i][j + items[i]]) {
                        state[i][j + items[i]] = state[i - 1][j] + value[i];
                    }
                }
            }
        }
        printState(state);

        int result = -1;
        int weight = -1;
        for (int i = 0; i < w + 1; i++) {
            if (state[items.length - 1][i] > result) {
                weight = i;
                result = state[items.length - 1][i];
            }
        }
//打印选择
        for (int i = items.length - 1; i >= 1; i--) {
            //物品i没选择
            if (state[i - 1][weight] == state[i][weight]) {
                printSelect(i, false);
            } else if (state[i - 1][weight - items[i]] + value[i] == state[i][weight]) {
                printSelect(i, true);
                weight -= items[i];
            }
        }
        if (weight > 0) {
            System.out.println("index==" + 0 + ", weight = " + items[0] + ", selected");
        } else {
            System.out.println("index==" + 0 + ", weight = " + items[0] + ", not selected");
        }

    }

    private void printSelect(int index, boolean isSelect) {
        if (isSelect) {
            System.out.println("index==" + index + ", weight = " + items[index] + ", value = " + value[index] + ", selected");
        } else {
            System.out.println("index==" + index + ", weight = " + items[index] + ", value = " + value[index] + ",not selected");
        }
    }

    public void printState(int[][] state) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < w + 1; j++) {

                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }
}
