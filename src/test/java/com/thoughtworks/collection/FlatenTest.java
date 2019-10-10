package com.thoughtworks.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class FlatenTest {

    @Test
    public void can_transform_two_dimensional_array_to_one() {
        Integer[][] array = new Integer[][]{{1}, {2}, {3, 4}};

        Integer[] result = new Integer[]{1, 2, 3, 4};
        List<Integer> resultList = Arrays.asList(result);

        Flaten flaten = new Flaten(array);

        assertThat(flaten.transformToOneDimesional()).isEqualTo(resultList);
    }

    @Test
    public void can_transform_two_dimensional_array_to_one_and_delete_repeated() {
        Integer[][] array = {{1, 2, 3}, {5, 2, 1, 4}, {2, 1}};

        Integer[] result = {1, 2, 3, 5, 4};
        List<Integer> resultList = Arrays.asList(result);

        Flaten flaten = new Flaten(array);
        assertThat(flaten.transformToUnrepeatedOneDimesional()).isEqualTo(resultList);
    }
}