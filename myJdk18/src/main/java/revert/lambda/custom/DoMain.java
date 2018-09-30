package revert.lambda.custom;

import revert.lambda.custom.impI.ZooImpI;

public class DoMain {

    public static void main(String[] args) {
        ZooImpI zooImpI = new ZooImpI();
        zooImpI.action(new AnimalAble() {
            @Override
            public void call() {
                System.out.println("猴子叫~~~~");
            }
        });

        zooImpI.action(() -> {
            System.out.println("鸡叫~~~~");
        });

    }

}
