package revert.collection;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(1,99);
        list.get(1);
        list.forEach(i -> {
            System.out.println(i);
        });


    }

}
