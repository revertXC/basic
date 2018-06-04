package revert.myThread.impI;

import revert.model.ZooEntity;
import revert.service.MySync;
import revert.service.syncClass.ZooClass;

/**
 * 线程3
 */
public class ThreadThree implements Runnable {
    private MySync mySync;

    public ThreadThree(MySync mySync){
        this.mySync = mySync;
    }

    @Override
    public void run() {
        System.out.println();
        int i = mySync.getSize();
        String opt = "删除";
        String ThreadName = Thread.currentThread().getName();
        System.out.println(ThreadName+" "+opt+"一个动物;当前动物个数："+ i);
        mySync.removeZoo(1);
        System.out.println(ThreadName+"占用锁3S");
        try{
            Thread.sleep(3000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
