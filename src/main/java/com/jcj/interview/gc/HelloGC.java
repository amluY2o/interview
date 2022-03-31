package com.jcj.interview.gc;

import java.util.concurrent.TimeUnit;

/**
 * 添加XX参数：
 *  布尔型，+表示开启，-表示关闭
 *      -XX:+PrintGCDetails
 *  K/V型，-XX:key=value
 *      -XX:MetaspaceSize=128m
 *
 * 如何查看一个正在运行的java程序，它的某一个jvm参数是否开启？具体值是多少
 * jps -l
 * jinfo -flag 参数名 进程编号
 * jinfo -flags 进程编号(所有参数)
 *
 *
 *
 * java -XX:+PrintFlagsInitial 查看初始值
 * java -XX:+PrintFlagsFinal -version   查看修改更新的值
 * java -XX:+PrintCommandLineFlags 查看命令行参数
 * = 初始值 := 修改值
 *
 *
 * JVM常用的配置参数：
 * -Xms 初始内存大小，默认物理内存1/64，等价于-XX:InitialHeapSize
 *  * -Xmx 最大分配内存，默认物理内存1/4，等价于-XX:MaxHeapSize
 *  * -Xss 设置单个线程栈的大小，一般默认512k~1024K，等价于-XX:ThreadStackSize
 *  * -XX:MetaspaceSize 设置元空间大小
 *  * -XX:PrintGCDetails 打印GC详情日志 [名称: GC前内存占用->GC后内存占用(该区内存总大小)
 *  * -XX:SurvivorRatio 设置新生代中eden和s0/s1的空间比例
 *  * -XX:NewRatio 配置新生代与老年代堆结构占比
 *  * -XX:MaxTenuringThreshold 设置垃圾的最大年龄，默认15
 *
 *
 *
 *
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello GC");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
