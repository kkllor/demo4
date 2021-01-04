package com.kkllor.sam

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.FileReader
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.PI

/**
 * @author kkllor
 * @date 2020/11/23 上午11:57
 */

val pool = Executors.newFixedThreadPool(2)

fun main() = runBlocking {
    launch {
        val start = System.currentTimeMillis()
        val content1 = async { readFiles("1.pdf") }
        val content2 = async { readFiles("2.pdf") }
        content1.await()
        println("----")
        content2.await()
        println("thread lasts:${System.currentTimeMillis() - start}")
    }.join()

    launch {
        val start = System.currentTimeMillis()
        val content1 = async { readFilesMainThread("1.pdf") }
        val content2 = async { readFilesMainThread("2.pdf") }
        content1.await()
        println("----")
        content2.await()
        println("main lasts:${System.currentTimeMillis() - start}")
    }.join()

//    launch {
//        val start = System.currentTimeMillis()
//        val content1 = async { computeTest() }
//        val content2 = async { computeTest()}
//        content1.await()
//        println("----")
//        content2.await()
//        println("thread lasts:${System.currentTimeMillis() - start}")
//    }.join()
//
//    launch {
//        val start = System.currentTimeMillis()
//        val content1 = async { computeTestMainThread() }
//        val content2 = async {computeTestMainThread()}
//        content1.await()
//        println("----")
//        content2.await()
//        println("main lasts:${System.currentTimeMillis() - start}")
//    }.join()

    Unit
}


suspend fun readFilesMainThread(fileName: String) = suspendCoroutine<String> { cont ->
    val lines = StringBuilder()
    val file = cont.javaClass.classLoader.getResource(fileName).file
    val fileReader = FileReader(file)
    fileReader.skip(500000)
//    fileReader.forEachLine { line ->
//        lines.append(line)
//        lines.append("\n")
//    }
    println("suspendCoroutine:${System.currentTimeMillis()} thread:${Thread.currentThread()}")
    cont.resume(lines.toString())
}

suspend fun readFiles(fileName: String) = suspendCoroutine<String> { cont ->

    pool.execute {
        val lines = StringBuilder()
        val file = cont.javaClass.classLoader.getResource(fileName).file
        val fileReader = FileReader(file)
        fileReader.skip(500000)
//        fileReader.forEachLine { line ->
//            lines.append(line)
//            lines.append("\n")
//        }
        println("suspendCoroutine:${System.currentTimeMillis()} thread:${Thread.currentThread()}")
        cont.resume(lines.toString())
    }
}

suspend fun computeTest() = suspendCoroutine<Double> { cont ->
    pool.execute {
        var result = 0.0
        repeat(1000000000) {
            result += PI * it * it
        }
        println("suspendCoroutine:${System.currentTimeMillis()} thread:${Thread.currentThread()} result = $result")
        cont.resume(result)
    }
}

suspend fun computeTestMainThread() = suspendCoroutine<Double> { cont ->
    var result = 0.0
    repeat(1000000000) {
        result += PI * it * it
    }
    println("suspendCoroutine:${System.currentTimeMillis()} thread:${Thread.currentThread()} result = $result")
    cont.resume(result)
}