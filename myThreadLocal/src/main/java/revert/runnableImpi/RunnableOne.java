package revert.runnableImpi;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 每根线程 开启一个 queue 阻塞队列
 */
public class RunnableOne implements Runnable {

//    private ThreadLocal threadLocal = new ThreadLocal();
    private ConcurrentHashMap<String, ArrayBlockingQueue<String>> concurrentHashMap;
    public RunnableOne(ConcurrentHashMap<String, ArrayBlockingQueue<String>> concurrentHashMap){
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
//        threadLocal.set(Thread.currentThread().getName() + " 的 ThreadLocal 值");
        Thread thread = Thread.currentThread();
        String code = thread.getName();
        synchronized (code){
            int i = new Random().nextInt(10) + 1;
            System.out.println(code + " 已经开始加载！！！ "+code+"执行 "+i+" 次任务");
            for(int index = 0 ; index < i ; index++){
                System.out.println();
                System.out.println(code + "开始执行任务"+index+"`````");
                ArrayBlockingQueue<String> queue = concurrentHashMap.get(code);
                if(queue == null){
                    queue = new ArrayBlockingQueue<String>(1);
                    concurrentHashMap.put(code, queue);
                    System.out.println(code + "Queue 实例成功");
                }
                try {
                    System.out.println(code + "开始阻塞·····");
                    /**如果9秒内没有消费 取消 阻塞*/
                    if(queue.offer(""+index,9, TimeUnit.SECONDS)){
                        System.out.println(code + "列队被消费，取消阻塞");
                    }else{
                        System.out.println(code + "取消阻塞·····");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(code + "执行任务"+index+"完成！！！····");
            }

        }

    }
}
