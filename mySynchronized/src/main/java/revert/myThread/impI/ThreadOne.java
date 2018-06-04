package revert.myThread.impI;

import revert.model.ZooEntity;
import revert.service.MySync;
import revert.service.syncClass.ZooClass;

/**
 * 线程1
 */
public class ThreadOne implements Runnable {

    private  MySync mySync;

    public ThreadOne(MySync mySync){
        this.mySync = mySync;
    }

    @Override
    public void run() {
        System.out.println();
        int i = mySync.getSize();
        String opt = "添加";
        String ThreadName = Thread.currentThread().getName();
        System.out.println(ThreadName+" "+opt+"一个动物;当前动物个数："+ i);
        mySync.addZoo(new ZooEntity(7L,"大脑虎"));
        System.out.println(ThreadName+"占用锁3S");
        try{
            Thread.sleep(3000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
