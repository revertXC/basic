package revert.doMain;

import revert.myThread.impI.ThreadFour;
import revert.myThread.impI.ThreadOne;
import revert.myThread.impI.ThreadThree;
import revert.myThread.impI.ThreadTwo;
import revert.service.syncClass.ZooClass;
import revert.service.syncStr.ZooStr;

public class Test {
    public static void main(String[] args) {

//        ZooClass zooClass = new ZooClass();

        ZooStr zooStr = new ZooStr("1","2");
//        ZooStr zooStr2 = new ZooStr("lock2");

//        ThreadOne threadOne = new ThreadOne(zooClass);
//        ThreadTwo threadTwo = new ThreadTwo(zooClass);
//        ThreadThree threadThree = new ThreadThree(zooClass);
//        ThreadFour threadFour = new ThreadFour(zooClass);

        ThreadOne threadOne = new ThreadOne(zooStr);
        ThreadTwo threadTwo = new ThreadTwo(zooStr);
        ThreadThree threadThree = new ThreadThree(zooStr);
        ThreadFour threadFour = new ThreadFour(zooStr);

        ThreadOne thread6 = new ThreadOne(zooStr);
        ThreadOne thread7 = new ThreadOne(zooStr);


        Thread thread1= new Thread(threadOne);
        Thread thread2= new Thread(threadTwo);
        Thread thread3= new Thread(threadThree);
        Thread thread4= new Thread(threadFour);
        Thread thread16= new Thread(thread6);
        Thread thread17= new Thread(thread7);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread16.start();
        thread17.start();

    }
}
