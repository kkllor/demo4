package com;

/**
 * @author kkllor
 * @date 2021/1/29 9:55 AM
 */
public class TestStrConstant {
    public static void main(String[] args) {
        String yijian1 = "意见";
        String yijian2 = new String("意见");
        System.out.println("意见" == yijian1);
        System.out.println(yijian1 == yijian2);
    }
}
