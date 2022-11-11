package com.mangkyu.stream.Quiz3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz3 {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    /**
     * ### 문제 3.1
     * 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
     * ex) numbers1 = [1,2,3], numbers2 =  [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
     */
    public List<Integer[]> quiz1() {
        List<Integer[]> collect = numbers1.stream()
                .flatMap(n1 -> numbers2.stream().map(n2 -> new Integer[]{n1, n2}))
                .collect(Collectors.toList());
        return Collections.emptyList();
    }

    /**
     * ### 문제 3.2
     * 위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
     * ex) numbers1 = [1,2,3], numbers2 =  [3,4] -> 12
     */
    public int quiz2() {
        return numbers1.stream()
                .flatMapToInt(n1 -> numbers2.stream().mapToInt(n2 -> n1 * n2))
                .max()
                .orElse(0);
    }

}
