package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int lowerLimit = Math.min(left, right);
        int upperLimit = Math.max(left, right);

        List<Integer> integerList = IntStream.rangeClosed(lowerLimit, upperLimit)
                .boxed()
                .collect(Collectors.toList());

        if(left > right)
            return integerList.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

        return integerList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream()
                .filter(this::isEven)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> evenList = new ArrayList<>();

        Arrays.stream(array)
                .filter(this::isEven)
                .forEach(evenList::add);

        return evenList;
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> commonList = new ArrayList<>();

        Arrays.stream(secondArray)
                .filter(num -> ifContains(firstArray, num))
                .forEach(commonList::add);

        return commonList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> uncommonList = Arrays.asList(firstArray);

        Arrays.stream(secondArray)
                .mapToInt(Integer::intValue)
                .boxed()
                .filter(num -> !ifContains(firstArray, num))
                .forEach(uncommonList::add);

        return uncommonList;
    }

    private boolean ifContains(int[] array, int num) {
        return Arrays.stream(array)
                .anyMatch(arrayNum -> arrayNum == num);
    }

    private boolean ifContains(Integer[] array, int num) {
        return Arrays.asList(array)
                .stream()
                .anyMatch(arrayNum -> arrayNum == num);
    }

    private boolean isEven(Integer num) {
        return num%2==0;
    }
}
