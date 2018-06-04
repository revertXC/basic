package revert.service.syncClass;

import revert.model.ZooEntity;
import revert.service.MySync;

import java.util.ArrayList;
import java.util.List;

/**
 * 动物园Class 锁
 */
public class ZooClass implements MySync {

    List<ZooEntity> listZoo = new ArrayList<>();
    public ZooClass(){
        for(int i=0 ;i<5 ; i++) {
            ZooEntity zooEntity = new ZooEntity();
            zooEntity.setId(Long.parseLong(i+""));
            zooEntity.setName("小柿子"+i);
            listZoo.add(zooEntity);
        }
    }

    public void addZoo(ZooEntity zooEntity){
        synchronized (ZooEntity.class){
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
        synchronized (ZooEntity.class){
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
        synchronized (ZooEntity.class){
            return listZoo.size();
        }
    }

}
