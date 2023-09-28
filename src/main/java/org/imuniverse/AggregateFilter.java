package org.imuniverse;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class AggregateFilter {

    public static int[] aggregateFilter(int[] arr1, int[] arr2) {
        IntPredicate evenPredicate = num -> num % 2 == 0;
        return Stream.of(arr1, arr2)
                .flatMapToInt(Arrays::stream)
                .filter(evenPredicate)
                .toArray();
    }
}
