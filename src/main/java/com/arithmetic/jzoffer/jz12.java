package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/21 10:23 PM
 */
public class jz12 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}

        };

//        char[][] board = new char[][]{
//                {'A'}
//        };
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] mark = new int[n][m];
                boolean isMath = match(board, word, mark, 0, i, j);
                if (isMath) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean match(char[][] board, String word, int[][] mark, int currentIndex, int boardX, int boardY) {
        if (boardX < 0 || boardY < 0 || boardX > board.length - 1 || boardY > board[0].length - 1) {
            return false;
        }

        if (mark[boardX][boardY] == 0) {
            if (board[boardX][boardY] == word.charAt(currentIndex)) {
                mark[boardX][boardY] = 1;
                if (currentIndex == word.length() - 1) {
                    return true;
                }
                boolean result = match(board, word, mark, currentIndex + 1, boardX, boardY - 1)
                        || match(board, word, mark, currentIndex + 1, boardX, boardY + 1)
                        || match(board, word, mark, currentIndex + 1, boardX - 1, boardY)
                        || match(board, word, mark, currentIndex + 1, boardX + 1, boardY);
                if (!result) {
                    mark[boardX][boardY] = 0;
                }
                return result;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
