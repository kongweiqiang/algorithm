package com.kwq.algorithm.files;

import java.io.File;
import java.util.concurrent.*;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/17
 * @DESC :
 */
public class FileChild {

    public static void main(String[] args) throws Throwable{
        for(int i=0 ; i<50 ;i++){
            executor.submit(()->{
                countDownLatch.countDown();
                System.out.println("第+"+ (countDownLatch.getCount()+1)+"+个线程:"+Thread.currentThread().getName());
            });
        }
        countDownLatch.await();
        System.out.println("开始");
        Thread.sleep(10000);
        System.out.println("结束");
    }

    public static int feed = 0;

    static CountDownLatch countDownLatch = new CountDownLatch(50);

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS, new LinkedBlockingQueue());


    public static File [] getFiles(File file,int start){
        File [] childFiles = getchildList(file);
        for(int i=start;i<childFiles.length ; i++){
            feed ++;
            File [] files = getFiles(childFiles[i],i+1);
            feed --;
        }
        return new File[]{};
    }

    public static File [] getchildList(File file){
        return new File[]{};
    }

    public static boolean hasChild(File file){
        return getchildList(file)!=null && getchildList(file).length !=0;
    }
}
