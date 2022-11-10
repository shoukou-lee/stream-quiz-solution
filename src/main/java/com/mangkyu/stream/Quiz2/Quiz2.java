package com.mangkyu.stream.Quiz2;

import lombok.val;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 아래와 같은 데이터가 저장된 리스트가 있다고 하자.
 * ```java
 * private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");
 * ```
 */
public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    /**
     * List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
     * ex) ("T", 1), ("a", 2) ...
     */
    public Map<String, Integer> quiz1() {
        return WORDS.stream()
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.toMap(key -> key, key -> 1, (oldValue, newValue) -> oldValue + newValue));
    }

    /**
     * ### 문제 2.2
     * List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
     * ex) ["Hello", "a", "Island", "b"] -> “H I”
     */
    public String quiz2() {
        return WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(word -> String.valueOf(word.charAt(0)).toUpperCase())
                .collect(Collectors.joining(" "));
    }

}
