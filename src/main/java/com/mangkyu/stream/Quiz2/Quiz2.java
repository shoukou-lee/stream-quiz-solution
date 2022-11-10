package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return new HashMap<>();
    }

    public String quiz2() {
        return null;
    }

}
