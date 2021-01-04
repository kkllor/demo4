package com.kkllor.sam

import kotlinx.coroutines.*
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.OutputFormat
import org.dom4j.io.SAXReader
import org.dom4j.io.XMLWriter
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets


/**
 * @author kkllor
 * @date 2020/11/24 上午9:22
 */

fun main(args: Array<String>) = runBlocking {
    //    readResource()
    readXmlByDom4J()
    Unit
}

suspend fun readResource() {
    withContext(Dispatchers.IO) {
        val classloader = Thread.currentThread().contextClassLoader
        classloader.getResourceAsStream("strings-en.xml").use {
            val streamReader = InputStreamReader(it, StandardCharsets.UTF_8)
            val reader = BufferedReader(streamReader)
            reader.lines().forEach {
                println(it)
            }
        }
    }
}

suspend fun readXmlByDom4J() {
    coroutineScope {
        val mapEn = mutableMapOf<String, Element>()
        var documentEn: Document? = null
        val mapCh = mutableMapOf<String, Element>()
        var documentCh: Document?
        val job1 = launch {
            val saxReader = SAXReader()
            val classloader = Thread.currentThread().contextClassLoader
            classloader.getResourceAsStream("strings-en.xml").use {
                documentEn = saxReader.read(it)
                val rootElement = documentEn!!.rootElement
                val iterator = rootElement.elementIterator()
                while (iterator.hasNext()) {
                    val element = iterator.next() as Element
                    // 获取所有属性名和属性值
                    element.attributes().firstOrNull { it.name == "name" }?.apply {
                        mapEn[value] = element
                    }
                }
            }
        }

        val job2 = launch {
            val saxReader = SAXReader()
            val classloader = Thread.currentThread().contextClassLoader
            classloader.getResourceAsStream("strings-ch.xml").use {
                documentCh = saxReader.read(it)
                val rootElement = documentCh!!.rootElement
                val iterator = rootElement.elementIterator()
                while (iterator.hasNext()) {
                    val element = iterator.next() as Element
                    rootElement.remove(element)
                    // 获取所有属性名和属性值
                    element.attributes().firstOrNull { it.name == "name" }?.apply {
                        mapCh[value] = element
                    }
                }
            }
        }
        joinAll(job1, job2)
        mapCh.keys.sorted().forEach {
            //如果en资源包含此key，则替换为ch对应资源
            if (mapEn.containsKey(it)) {
                documentEn!!.rootElement.remove(mapEn[it])
                println("remove ${it}")
            }
            documentEn!!.rootElement.add(mapCh[it])
            println("add ${it}")
        }

        val target = File("out/strings.xml").also {
            if (!it.exists()) {
                it.createNewFile()
            }
        }

        val xmlwriter =
            XMLWriter(FileOutputStream(target), OutputFormat.createPrettyPrint().also { it.encoding = "UTF-8" })
        xmlwriter.write(documentEn)
        xmlwriter.flush()
    }
}