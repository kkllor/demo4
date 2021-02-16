package com.kkllor.sam


/**
 * @author kkllor
 * @date 2021/2/15 10:08 AM
 */

open class A(x: Int) {
    open val y: Int = x

    companion object objInA {
        init {
            println("init objInA")
        }

        val x: Int = Integer.MAX_VALUE

        val BImpl = {
            fun testB() {
            }
        }
    }
}

object obj {
    init {
        println("init obj")
    }
}

interface B {
    fun testB()
}

val ab: A = object : A(1), B {
    init {
        println("init ab")
    }

    override fun testB() {
        println("testB")
    }

    override val y = 15
}

fun main(args: Array<String>) {
//    println((ab as B).testB())
//    println(A.x)
//    val companionA = A
    obj
}