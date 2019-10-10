package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer> integerList;

    public Filter(List<Integer> integerList) {
     this.integerList = integerList;
    }

    public List<Integer> filterEven() {
        return integerList.stream()
                .filter(num -> num%2==0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return integerList.stream()
                .filter(num -> num%3==0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream()
                .filter(secondList::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return integerList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean ifContains(List<Integer> intList, int num) {
        return intList.stream()
                .anyMatch(integer -> integer == num);
    }
}