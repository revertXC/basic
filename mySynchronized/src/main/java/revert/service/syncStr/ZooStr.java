package revert.service.syncStr;

import revert.model.ZooEntity;
import revert.service.MySync;

import java.util.ArrayList;
import java.util.List;

/**
 * String 锁
 */
public class ZooStr implements MySync {

    String lock1 = "default";
    String lock2 = lock1;

    private static List<ZooEntity> listZoo = new ArrayList<>();
    static {
        for(int i=0 ;i<5 ; i++) {
            ZooEntity zooEntity = new ZooEntity();
            zooEntity.setId(Long.parseLong(i+""));
            zooEntity.setName("小柿子"+i);
            listZoo.add(zooEntity);
        }
    }
    public ZooStr(){

    }

    public ZooStr(String lock1,String lock2){
        super();
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void addZoo(ZooEntity zooEntity){
        synchronized (lock1){
            Long mills = 5000L;
            System.out.println(Thread.currentThread().getName()+" "+(mills/1000)+"秒后添加动物：" + zooEntity);
            try{
                Thread.sleep(mills);
            }catch (Exception e){
                e.printStackTrace();
            }
            listZoo.add(zooEntity);
        }
    }

    public void removeZoo(int i){
        synchronized (lock2){
            Long mills = 5000L;
            System.out.println(Thread.currentThread().getName()+" "+(mills/1000)+"秒后删除动物：" + listZoo.get(i));
            try{
                Thread.sleep(mills);
            }catch (Exception e){
                e.printStackTrace();
            }
            listZoo.remove(i);
        }
    }

    public int getSize(){
        synchronized (lock2){
            return listZoo.size();
        }
    }

}
