package revert.runnableImpi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 消费列队
 */
public class ConsumeRun implements Runnable {

    private ConcurrentHashMap<String, ArrayBlockingQueue<String>> concurrentHashMap;
    /**指定消耗生产者*/
    private String threadName;
    public ConsumeRun(ConcurrentHashMap<String, ArrayBlockingQueue<String>> concurrentHashMap, String threadName){
        this.concurrentHashMap = concurrentHashMap;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try{
//            synchronized (threadName){
                boolean flag = true;
                System.out.println("开始消费······");
                while(flag){
//                    Thread.sleep(1000L);
                    ArrayBlockingQueue<String> queue = concurrentHashMap.get(threadName);
                    if(queue != null){
                        String val = queue.poll(2, TimeUnit.SECONDS);
                        if(val == null){
                            System.out.println(threadName + "列队值 取完为空#######################");
                            System.out.println("转化成 T2线程####################");
                            if(threadName.equals("T2")){
                                System.out.println("T2 也被消耗完毕 结束########################");
                                flag = false;
                            }
                            threadName = "T2";
                        }else{
                            System.out.println(threadName + " 取值为：" +val+"#####################");
                        }
                    }
                }
//            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
