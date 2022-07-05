package com.learn;

/**
 * @author kkllor
 * @date 2022/7/4 10:27 PM
 */
public class TestCombine {

    public static void main(String[] args) {
        new TestCombine().Combination();
    }

    public  void Combination() {
        String[] str = {"a", "b", "c"};
        int n = str.length;    //元素个数。
        int nbit = 1 << n;   // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。求出位图全组合的结果个数：2^n - 1
        System.out.println("全组合结果个数为：" + nbit);

        for (int i = 0; i < nbit; i++) {    //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("组合数值  " + i + " 对应编码为： ");
            for (int j = 0; j < n; j++) {      //每个数二进制最多可以左移n次，即遍历完字符在位置上的所有可能
                int tmp = 1 << j;
                if ((tmp & i) != 0) {         //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);    //这里是一次打印一个字符，而不是一次性打印出abc三个字符,print()而不是println()
                }
            }
            System.out.println();
        }
    }

}
