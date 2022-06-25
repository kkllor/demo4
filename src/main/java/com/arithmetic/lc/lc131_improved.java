package com.arithmetic.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/6/24 10:35 PM
 */
public class lc131_improved {

    public static void main(String[] args) {
//        "a","b","bab"
        try {
            System.out.println(new lc131_improved().partition("abbab"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        /*

        1  0  0  0  0
        1  1  0  0  0
        1  1  1  0  0
        1  1  1  1  0
        1  1  1  1  1

         */

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

}
