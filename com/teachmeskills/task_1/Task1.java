package com.teachmeskills.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Create a collection of the ArrayList class and fill it with random elements of the Integer type.
 * With Streams:
 * - Remove duplicates
 * - Display all even elements in the range from 7 to 17 (inclusive)
 * - Multiply each element by 2
 * - Sort and display the first 4 elements
 * - Display the number of elements in the stream
 * - Display the arithmetic mean of all numbers in the stream
 */

public class Task1 {
    public static void main(String[] args) {
        int quantity = 3;
        int multiplier = 2;
        List<Integer> list = getRandomList(quantity);
        System.out.println("Random list: " + list);
        System.out.println("Distinct values: " + distinct(list));
        System.out.println("Filter: " + filter(list));
        System.out.println("Multiply x2 each element: " + multiply(list, multiplier));
        System.out.println("Sort: " + sort(list));
        System.out.println("Count: " + count(list));
        System.out.println("Average: " + average(list));
        System.out.println("Another average: " + avg(list));
    }

    private static List<Integer> getRandomList(int quantity) {
        Random generator = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int counter = 0; counter < quantity; counter++) {
            randomList.add(generator.nextInt(20));
        }
        return randomList;
    }

    private static List<Integer> distinct(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static List<Integer> filter(List<Integer> list) {
        return list.stream().filter(el -> el % 2 == 0 && el > 7 && el <= 17).collect(Collectors.toList());
    }


    private static List<Integer> multiply(List<Integer> list, int multiplier) {
        return list.stream().map(el -> el * multiplier).collect(Collectors.toList());
    }

    private static List<Integer> sort(List<Integer> list) {
        return list.stream().sorted().limit(4).collect(Collectors.toList());
    }

    private static int count(List<Integer> list) {
        return (int) list.stream().count();
    }

    private static double average(List<Integer> list) {
        Optional<Integer> sum = list.stream().reduce((accum, val) -> accum + val);
        if (sum.isPresent()) {
            return sum.get() / (double) list.size();
        }
        return 0;
    }

    private static double avg(List<Integer> list) {
        return list.stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElseGet(() -> 0);
    }
}