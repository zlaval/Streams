package com.zlrx.streams;

import java.util.List;
import java.util.stream.Collectors;

import static com.zlrx.streams.TestData.testStringData;

public class Pipeline {


    private void createPipleine() {
        List<String> data = testStringData();

        List<String> newWorldCollection =
                data.stream()
                        .distinct()
                        .filter(str -> str.length() > 3)
                        .sorted()
                        .map(str -> "Learn new word: " + str)
                        .collect(Collectors.toList());

        System.out.println(newWorldCollection);
    }


    private void start() {
        createPipleine();
    }

    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        pipeline.start();
    }


}
