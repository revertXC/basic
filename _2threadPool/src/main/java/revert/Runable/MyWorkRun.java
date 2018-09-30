package revert.Runable;

public class MyWorkRun implements Runnable {

    private int i;

    public MyWorkRun(int i){
        this.i = i;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"-------执行的Val:"+i);
            Thread.sleep(4000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
