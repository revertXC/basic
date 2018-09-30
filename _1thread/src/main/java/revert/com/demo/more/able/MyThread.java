package revert.com.demo.more.able;

public class MyThread implements Runnable {

    private static int sum = 0;

    private static int i = 10;

    @Override
    public void run() {
        synchronized (MyThread.class){

        }
        while(i > 0){
                System.out.println("当前执行的数值为："+i);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
    }
}
