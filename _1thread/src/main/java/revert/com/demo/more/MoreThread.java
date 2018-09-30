package revert.com.demo.more;

import revert.com.demo.more.able.MyThread;

import java.util.concurrent.ThreadPoolExecutor;

public class MoreThread {

    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
//        for (int i=0; i< 10; i++){
//            handle(i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("总执行时间："+((endTime - startTime) / 1000) + " S");

        long startTime = System.currentTimeMillis();
            MyThread myThread = new MyThread();
            new Thread(myThread).start();
            new Thread(myThread).start();
        long endTime = System.currentTimeMillis();
        System.out.println("总执行时间："+((endTime - startTime) / 1000) + " S");


    }

    public static void handle(final int i) throws InterruptedException {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("当前执行的数值为："+i);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

    }

}
