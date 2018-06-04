package revert.myThread.impI;

import revert.service.MySync;

/**
 * 线程2
 */
public class ThreadFour implements Runnable {
    private MySync mySync;

    public ThreadFour(MySync mySync){
        this.mySync = mySync;
    }

    @Override
    public void run() {
        System.out.println();
        int i = mySync.getSize();
        String ThreadName = Thread.currentThread().getName();
        System.out.println(ThreadName+" 查询当前动物个数："+ i);
        System.out.println(ThreadName+" 占用锁3S");
        try{
            Thread.sleep(3000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
