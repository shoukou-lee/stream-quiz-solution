package com.mangkyu.stream.Quiz5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    /**
     * ### 문제 5.1
     * 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.
     */
    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
    }

    /**
     * ### 문제 5.2
     * 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 문자열 중에서 가장 긴 것의 길이를 출력하시오.
     */
    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    /**
     * ### 문제 5.3
     * 임의의 로또번호(1~45)를 정렬해서 출력하시오.
     */
    public List<Integer> quiz3() {
        final int start = 1;
        final int end = 46;
        return new Random().ints(start, end)
                .distinct()
                .limit(6)
                .boxed() // Intstream -> Stream<Integer>
                .collect(Collectors.toList());
    }

    /**
     * ### 문제 5.4
     * 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
     */
    public List<Integer[]> quiz4() {
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap(n1 -> IntStream.rangeClosed(1, 6)
                        .boxed()
                        .map(n2 -> new Integer[]{n1, n2}))
                .filter(i -> i[0] + i[1] == 6)
                .collect(Collectors.toList());
    }

}
