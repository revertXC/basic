package revert.service;

import revert.model.ZooEntity;

/**
 * 操作接口
 */
public interface MySync {

    void addZoo(ZooEntity zooEntity);

    void removeZoo(int i);

    int getSize();

}
