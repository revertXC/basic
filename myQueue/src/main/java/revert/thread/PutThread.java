package revert.thread;

import revert.test.Test1;

import java.util.concurrent.TimeUnit;

public class PutThread implements Runnable {
    @Override
    public void run() {
        /**当列队空间不足时 阻塞*/
        boolean b = false;
        try {
            b = Test1.arrayBlockingQueue.offer("222",3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(b){
            System.out.println("重新赋值了");
        }else{
            System.out.println(b + "赋值时间过期");
        }
    }
}
