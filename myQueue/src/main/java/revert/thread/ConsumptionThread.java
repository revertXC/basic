package revert.thread;

import revert.test.Test1;

public class ConsumptionThread implements Runnable {
    @Override
    public void run() {
        try{
            System.out.println("Thread---- 睡眠二秒在取值");
            Thread.sleep(50000);
            Object obj = Test1.arrayBlockingQueue.take();
            System.out.println("Thread----消费了 "+obj);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
