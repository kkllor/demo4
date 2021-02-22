package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/2 8:41 PM
 */
public class DpCoin {
    //1,3,5
    public static void main(String[] args) {
        int result = solution(23);
        System.out.println();
        System.out.println("result = " + result);
    }

    public static int solution(int target) {
        int[] state = new int[target + 1];
        state[1] = 1;
        state[2] = 2;
        state[3] = 1;
        state[4] = 2;
        state[5] = 1;
        for (int i = 6; i <= target; i++) {
            state[i] = Math.min(state[i - 1], Math.min(state[i - 3], state[i - 5])) + 1;
        }

        int index = target;
        while (index > 0) {
            int preValue = state[index] - 1;
            if (index - 1 >= 0 && preValue == state[index - 1]) {
                index -= 1;
                System.out.print(1 + " ,");
            } else if (index - 3 >= 0 && preValue == state[index - 3]) {
                index -= 3;
                System.out.print(3 + " ,");
            } else if (index - 5 >= 0 && preValue == state[index - 5]) {
                index -= 5;
                System.out.print(5 + " ,");
            }
        }

        return state[target];
    }
}
