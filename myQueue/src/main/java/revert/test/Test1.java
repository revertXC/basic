package revert.test;

import revert.thread.ConsumptionThread;
import revert.thread.PutThread;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
    public static void main(String[] args) throws InterruptedException {

        String val = "111";
        arrayBlockingQueue.put(val);
        System.out.println("存储了"+val);
        System.out.println("线程阻塞 无法添加了");

        System.out.println("开启线程");
        ConsumptionThread consumptionThread = new ConsumptionThread();
        PutThread putThread = new PutThread();
        Thread thread = new Thread(consumptionThread);
        Thread thread2 = new Thread(putThread);
        thread2.start();
        thread.start();
        System.out.println("线程全部启动完毕···············");
    }


}
