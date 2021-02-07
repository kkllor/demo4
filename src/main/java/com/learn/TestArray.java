package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/2/5 9:15 AM
 */
public class TestArray {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("12","123","123");
        Object[] obj = strList.toArray();
        obj[0] = 12;
        System.out.println(obj.getClass().getCanonicalName());
    }
}
