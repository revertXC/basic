package revert.model;

import java.io.Serializable;

/***
 * 动物园实体类
 */
public class ZooEntity implements Serializable {

    public ZooEntity() {
    }

    public ZooEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id; /**编号*/
    private String name; /**名称*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "ZooEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
