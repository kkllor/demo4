package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/26 7:29 PM
 */
public class jz19_uncomplete {
    /*
    输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
//        "aab"
//        "c*a*b"
//        "ab"
//".*c"
        try {
            System.out.println(new jz19_uncomplete().isMatch("ab", ".*c"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      /*
    a*b
    aaa

    a*a
    aaa

    a
    aaa

     */

    public boolean isMatch(String s, String p) {
      return false;
    }
}
