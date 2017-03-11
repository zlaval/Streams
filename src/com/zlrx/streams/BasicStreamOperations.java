package com.zlrx.streams;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.zlrx.streams.TestData.testStringData;

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

    public void otherInterestingStreamOperations() {
        List<String> testData = testStringData();
        boolean anyWordLongerThanFiveCharacter = testData.stream().anyMatch(str -> str.length() > 5);

        OptionalInt sumOfFirstHundredNumber = IntStream.range(0, 100).reduce((accumulator, number) -> accumulator += number);
        System.out.println(sumOfFirstHundredNumber);

        printSeparator();

        testData.stream().distinct().forEach(System.out::println);
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
        printSeparator();
        otherInterestingStreamOperations();
    }


    private void printSeparator() {
        System.out.println("====================================");
    }

}
