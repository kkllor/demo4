package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/1/29 11:04 AM
 */
public class TestGeneric {

    public static class Animal {

    }

    public static class Human extends Animal {
        protected String getHairColor() {
            return "grey";
        }
    }

    public static class Asia extends Human {

    }


    public static class Africa extends Human {

    }

    public static void main(String[] args) {
        List<? super Human> list = new ArrayList<Animal>();
    }
}
