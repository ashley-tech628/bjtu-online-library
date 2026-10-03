/**
 */
package com.framework.common.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * Date:2021/6/26
 * Title: 线程池工具类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public class ThreadPool {

    public static ExecutorService executor = new ThreadPoolExecutor(4, 8, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(200), new ThreadPoolExecutor.CallerRunsPolicy());

}
