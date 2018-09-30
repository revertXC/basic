package revert;

import revert.Runable.MyWorkRun;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        /** 核心线程数：不会被GC*/
        int corePoolSize = 2;

        /** 线程池最大容量*/
        int maximumPoolSize = 20;

        /** 非核心线程 闲时时间*/
        int keepAliveTime = 3000;

        /** 时间单位*/
        TimeUnit unit = TimeUnit.SECONDS;

        /** 工作阻塞队列*/
        BlockingQueue queue = new LinkedBlockingQueue(37);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                                                            corePoolSize,
                                                            maximumPoolSize,
                                                            keepAliveTime,
                                                            unit,
                                                            queue,
                                                            new ThreadPoolExecutor.CallerRunsPolicy()
                                                    );

        long startTime = System.currentTimeMillis();
        for(int i=0; i< 40 ;i++){
            threadPoolExecutor.execute(new MyWorkRun(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间："+(endTime - startTime)/1000);

    }

}
