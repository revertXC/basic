package revert.test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import revert.runnableImpi.ConsumeRun;
import revert.runnableImpi.RunnableOne;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    private static ConcurrentHashMap<String, ArrayBlockingQueue<String>> concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) throws FileNotFoundException {

        RunnableOne runnableOne = new RunnableOne(concurrentHashMap);

        Thread t1 = new Thread(runnableOne);
        Thread t2 = new Thread(runnableOne);

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();

        System.out.println("生产者实例完毕！ 开始消费诶");

        ConsumeRun consumeRun = new ConsumeRun(concurrentHashMap, "T1");
        Thread c1 = new Thread(consumeRun);
        c1.setPriority(1);
        c1.start();

    }
}
