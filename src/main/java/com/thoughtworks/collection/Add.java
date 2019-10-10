package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum=0;
        int lowerLimit = Math.min(leftBorder, rightBorder);
        int upperLimit = Math.max(leftBorder, rightBorder);

        for(int i= lowerLimit; i<=upperLimit; i++){
            if(isEven(i))
                sum+=i;
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum=0;
        int lowerLimit = Math.min(leftBorder, rightBorder);
        int upperLimit = Math.max(leftBorder, rightBorder);

        for(int i= lowerLimit; i<=upperLimit; i++){
            if(!isEven(i))
                sum+=i;
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .reduce(0, (sum, num) -> 3 * num + 2 + sum);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(this::performOperationIfOdd)
                .collect(Collectors.toList());
    }

    private Integer performOperationIfOdd(Integer num) {
        if(isEven(num))
            return num;
        else
            return num *3 + 2;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(num -> num%2==1)
                .map(num -> 3 * num + 5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(this::isEven)
                .collect(Collectors.toList());

        int middle = evenList.size()%2;
        if(middle == 0){
            int medianSum = evenList.get(middle)+evenList.get(middle+1);
            return (double) medianSum /2;
        } else
            return evenList.get(middle).doubleValue();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(this::isEven)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(this::isEven)
                .anyMatch(num -> num==specialElment);
    }


    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(this::isEven)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(this::isEven)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> oddList = arrayList.stream()
                .filter(num -> !isEven(num))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return arrayList;//.stream()
//                .map(num -> )
    }

    private boolean isEven(Integer num) {
        return num%2==0;
    }

}
