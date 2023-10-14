package org.imuniverse.streams;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class PlayStreams {

    public static void main(String[] args) {

        List<String> marvels = Arrays.asList("IronMan", "AntMan", "CaptainAmerica", "Hulk", "Thor", "DoctorStrange");

        //toCollection method usage to collect in specific collection
        LinkedList<String> customList = marvels.stream()
                .filter(h -> h.startsWith("I"))
                .collect(toCollection(LinkedList::new));

        //toMap - converting a list into a Map
        Map<String, Integer> mapFromList = marvels.stream()
                .collect(toMap(Function.identity(), String::length));

        //collectingAndThen - perform an extra operation on collected collection
        List<String> unmodifiableList = marvels.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));

        //Joining for List<String>
        String joiningList = marvels.stream().collect(joining("-","Marvel-","-SuperHeroes"));

        //Counting the collected elements in the collect method
        Map<String, Long> stringLengthMap = marvels.stream().collect(groupingBy(Function.identity(), counting()));
        stringLengthMap.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println();

        //Collectors summarizingXXX (int, long, double). Also averaging and summing of these primitives can be done.
        DoubleSummaryStatistics summarizingStringsInList = marvels.stream().collect(summarizingDouble(String::length));

        Optional<String> longestStringInList = marvels.stream().collect(maxBy(Comparator.comparing(String::length)));
        longestStringInList.ifPresent(System.out::println);
        System.out.println();

        //Collectors groupingBy - is used to group object by certain attribute in the iterable
        Map<Integer, Set<String>> stringLengthWiseMap = marvels.stream().collect(groupingBy(String::length, toSet()));
        stringLengthWiseMap.forEach((k,v) -> System.out.println(v));

        //Collectors partitioningBy - is specialised case of groupingBy.
        // The Map has two keys - true and false based on the predicate used to group the collection

        Map<Boolean, List<String>> stringsGt7Map = marvels.stream().collect(partitioningBy(s -> s.length() > 7));
        stringsGt7Map.forEach((k,v) -> System.out.println(k + " " + v));

        //Collectors - teeing (I understand it as combining) is available from Java 12.
        String teeingString = marvels.stream()
                .collect(teeing(minBy(Comparator.comparing(String::length)),
                        maxBy(Comparator.comparing(String::length)), (s, s2) -> s.orElse(null) + "," + s2.orElse(null)));
        System.out.println(teeingString);

    }
}
