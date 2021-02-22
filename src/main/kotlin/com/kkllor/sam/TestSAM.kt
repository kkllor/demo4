package com.kkllor.sam

/**
 * @author kkllor
 * @date 2021/2/16 2:27 下午
 */

fun interface TestSAM {
    fun f(s: String)
}

fun testSam(testSAM: TestSAM) {
    testSAM.f("123")
}

fun main(args: Array<String>) {
    testSam { println(it.hashCode()) }
}