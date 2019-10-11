package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .reduce(Integer.MIN_VALUE, Math::max);
    }

    public double getMinimum() {
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .reduce(Integer.MAX_VALUE, Math::min);
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0, Double::sum)
                 / arrayList.size();
    }

    public double getOrderedMedian() {
        int median = arrayList.size() / 2;

//        if(isEven(arrayList.size())) {
//            return arrayList.stream()
//                .reduce(new ArrayList<Integer>(), (list, num) -> {
//
//                });
//        }

        return arrayList.get(median).doubleValue();
    }

    public int getFirstEven() {
        return arrayList.stream()
                .reduce(Integer.MAX_VALUE, (even, num) -> {
                    if(even != Integer.MAX_VALUE)
                        return even;

                    if(isEven(num))
                        return num;

                    return even;
                });
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }

    private boolean isEven(Integer num) {
        return num%2==0;
    }
}
