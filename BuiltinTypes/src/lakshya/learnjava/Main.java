package lakshya.learnjava;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
	    // data types
        System.out.printf("byte minimum = %s, maximum = %s%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short minimum = %s, maximum = %s%n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int minimum = %s, maximum = %s%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long minimum = %s, maximum = %s%n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("float minimum = %s, maximum = %s%n", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("double minimum = %s, maximum = %s%n", Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.printf("char minimum = %s, maximum = %s%n", Character.MIN_VALUE, Character.MAX_VALUE);

        //BigDecimal
        BigDecimal z = new BigDecimal("123.32423423454456566786774423423425652526635667686778943");
        System.out.printf("z is %.99f\n", z);
        System.out.println("z is " + z);

        //accuracy
        double res1 = 0.1*7;
        double res2 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        System.out.println("res1 is " + res1);
        System.out.println("res2 is " + res2);
        System.out.println("difference is " + (res2 - res1));

        System.out.printf("res1 is %f\n", res1);
        System.out.printf("res2 is %f\n", res2);
        System.out.printf("difference is %.99f\n", res2 - res1);

        //BigDecimal Accuracy;
        BigDecimal oneTenth = BigDecimal.valueOf(0.1);
        BigDecimal result1 = oneTenth.multiply(BigDecimal.valueOf(7));
        BigDecimal result2 = oneTenth
                .add(oneTenth)
                .add(oneTenth)
                .add(oneTenth)
                .add(oneTenth)
                .add(oneTenth)
                .add(oneTenth);

        BigDecimal difference = result1.subtract(result2);
        System.out.printf("result1 is %.99f \n", result1);
        System.out.printf("result2 is %.99f \n", result2);
        System.out.printf("difference is %.99f \n", difference);

        boolean checkDifference = res1 - res2 == 0;
        System.out.println(checkDifference);
    }
}
