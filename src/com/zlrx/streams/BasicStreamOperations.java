package com.zlrx.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamOperations {


    private void forEachStream() {
        List<String> testData = testStringData();
        testData.stream().forEach(System.out::println);
    }

    private void countStream() {
        List<String> testData = testStringData();
        long count = testData.stream().count();
        System.out.println(count);
    }

    private void filterStream() {
        List<String> testData = testStringData();
        List<String> filtered = testData.stream().filter(str -> str.length() == 3).collect(Collectors.toList());
        System.out.println(filtered);
    }

    private void sortStream() {
        List<String> testData = testStringData();
        testData.stream().sorted().forEach(System.out::println);
        printSeparator();
        testData.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        //a fenti sorted a beepitett fugvenyt hasznalva:
        //testData.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private void mapStream() {
        class Word {
            String name;

            Word(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Szó: " + name;
            }
        }

        List<String> testData = testStringData();
        testData.stream().map(str -> new Word(str)).forEach(System.out::println);

        //egyszerusitve a fenti map Function-jet:
        //testData.stream().map(Word::new).forEach(System.out::println);
    }


    public static void main(String[] args) {
        BasicStreamOperations basicStreamOperations = new BasicStreamOperations();
        basicStreamOperations.start();
    }

    private void start() {
        forEachStream();
        printSeparator();
        countStream();
        printSeparator();
        filterStream();
        printSeparator();
        sortStream();
        printSeparator();
        mapStream();
    }

    private List<String> testStringData() {
        List<String> strings = new ArrayList<>();
        strings.add("foo");
        strings.add("bar");
        strings.add("home");
        strings.add("sworld");
        strings.add("play");
        strings.add("animal");
        strings.add("car");
        strings.add("sun");
        strings.add("java");
        return strings;
    }

    private void printSeparator() {
        System.out.println("====================================");
    }

}
