package com.kkllor.sam

/**
 * @author kkllor
 * @date 2021/2/16 2:19 下午
 */

interface Base {
    fun printMsg()
}

class MyBase : Base {
    override fun printMsg() {
        println("my base print")
    }
}

class HisBase : Base {
    override fun printMsg() {
        println("his base print")
    }
}

class DelegationBase(b: Base) : Base by b

fun main(args: Array<String>) {

    val myBase = MyBase()
    val hisBase = HisBase()
    val delegationBase = DelegationBase(hisBase)
    delegationBase.printMsg()
}