package learning.rasw.designpatterns.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

    private ArrayUtils(){}

    public static String toString(int[] intArray, String delimiter){

        return IntStream.of(intArray)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(delimiter));
    }
}
