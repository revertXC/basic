package revert.lambda.sys;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDoMain {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("99","3","5","9","10");
        list.sort((v1, v2) -> {return v1.compareTo(v2);});
        list.forEach(s -> {
            System.out.println(s);
        });
        System.out.println();
        list.forEach( (String s) ->{
            System.out.println(s);
        });

    }

}
