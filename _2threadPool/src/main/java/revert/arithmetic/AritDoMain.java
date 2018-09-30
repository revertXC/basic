package revert.arithmetic;

public class AritDoMain {

    public static void main(String[] args) {
        String binaryStr = Integer.toBinaryString(50);
        System.out.println(binaryStr);

        String binaryStr2 = Integer.toBinaryString(49);
        System.out.println(binaryStr2);

        String binaryStr3 = Integer.toBinaryString(48);
        System.out.println(binaryStr3);

        String binaryStr4 = Integer.toBinaryString(51);
        System.out.println(binaryStr4);

        String binaryStr5 = Integer.toBinaryString(2);
        System.out.println(binaryStr5);

        String binaryStr6 = Integer.toBinaryString(-50);
        System.out.println(binaryStr6);

        System.out.println(50 & 49);
        System.out.println(50 | 49);
        System.out.println(50 & ~49);
    }

}
