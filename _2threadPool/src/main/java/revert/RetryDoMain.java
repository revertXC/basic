package revert;

public class RetryDoMain {

    public static void main(String[] args) {
        int count = 0;
        retry:
        for (; ; ) {
            count = 0;
            for (; ; ) {
                count++;
                System.out.println("count==" + count);
                if (count % 5 == 0) {
                    break retry;
                }
            }
        }
        System.out.println("Hello World");
    }
}
