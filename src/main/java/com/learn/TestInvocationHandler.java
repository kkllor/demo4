package com.learn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kkllor
 * @date 2021/1/22 5:01 PM
 */
public class TestInvocationHandler {
    interface sayHello {
        void hello();
    }

    static class Plain implements sayHello {

        @Override
        public void hello() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        Plain plain = new Plain();
        Object proxyObj = Proxy.newProxyInstance(plain.getClass().getClassLoader(), new Class[]{sayHello.class}, (proxy, method, args1) -> {

            System.out.println("method " + method.getName() + " start ");
            Object ret = method.invoke(plain, args1);
            System.out.println("method " + method.getName() + " end ");

            return ret;
        });
        proxyObj.toString();
        ((sayHello) proxyObj).hello();
    }
}



