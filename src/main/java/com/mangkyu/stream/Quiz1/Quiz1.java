package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 아래와 같은 User.csv가 있다고 할 때, 아래의 CSV 데이터를 조회하여 아래와 같은 결과를 출력한다고 하자.
 * ```text
 * //User.csv
 * 이름, 취미, 소개
 * 김프로, 축구:농구:야구, 구기종목 좋아요
 * 정프로, 개발:당구:축구, 개발하는데 뛰긴 싫어
 * 앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아
 * 죠르디, 스포츠댄스:개발, 개발하는 죠르디 좋아
 * 박프로, 골프:야구, 운동이 좋아요
 * 정프로, 개발:축구:농구, 개발도 좋고 운동도 좋아
 * ```
 */
public class Quiz1 {

    /**
     ### 문제 1.2
     위와 같은 데이터를 조회하여 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
     */
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                // 취미의 1D 리스트
                .map(line -> line[1].replaceAll("\\s", ""))
                // 개별 취미를 ':' 단위로 자르고 스트림으로 만든다. 이후, flatMap으로 하나의 stream으로 합친다.
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                // Map으로 모은다. 키로는 hobby, value로는 기본적으로 1이 들어가며, merge 정책은 이전 값과 이후 값을 더하도록 한다.
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> oldValue + newValue));
    }

    /**
     * ### 문제 1.2
     * 위와 같은 데이터를 조회하여 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
     */
    public Map<String, Integer> quiz2() throws IOException {
        final String lastName = "정";

        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .filter(line -> line[0].startsWith(lastName))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> oldValue + newValue));
    }

    /**
     * ### 문제 1.3
     * 위와 같은 데이터를 조회하여 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
     */
    public int quiz3() throws IOException {
        final String interestedKeyword = "좋아";
        List<String[]> csvLines = readCsvLines();

        List<String> collect = csvLines.stream()
                .map(line -> line[2])
                // suffix로 공백을 붙여주고 키워드로 스플릿한다. 이때, (배열 크기 - 1)은 키워드 개수
                .flatMap(introduces -> Arrays.stream((introduces + " ").split(interestedKeyword)))
                .collect(Collectors.toList());

        return collect.size() - csvLines.size();
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
