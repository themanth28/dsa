package java8;

import java.util.Arrays;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {

//        1.Method reference to static method
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

//        2.Method reference to instance method
    }
}
