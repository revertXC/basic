package revert.com.demo.sigle;

/**
 * 单线程
 */
public class SigleThread {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i=0; i< 10; i++){
            handle(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总执行时间："+((endTime - startTime) / 1000) + " S");
    }

    public static void handle(int i) throws InterruptedException {
        System.out.println("当前执行的数值为："+i);
        Thread.sleep(1000L);
    }

}
