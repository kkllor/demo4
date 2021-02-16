package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/1/29 11:04 AM
 */
public class TestGeneric {

    public static class Animal<T> {
        private T extra;

        public T getExtra() {
            return extra;
        }

        public void setExtra(T extra) {
            this.extra = extra;
        }
    }

    public static class Chicken extends Animal<String>{
        @Override
        public String getExtra() {
            return super.getExtra();
        }
    }

    public static void main(String[] args) {

    }
}
