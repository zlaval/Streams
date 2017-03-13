package com.zlrx.streams;

import java.util.List;

import static com.zlrx.streams.TestData.printSeparator;

public class StreamExecutionOrder {


    private void wrongOrder() {
        List<String> data = TestData.fewTestStringData();

        data.stream()
                .sorted((a, b) -> {
                    System.out.println("Sort element, compare " + a + " to " + b);
                    return a.compareTo(b);
                })
                .map(str -> {
                    System.out.println("Map element: " + str);
                    return str;
                })
                .filter(str -> {
                    System.out.println("Filter element: " + str);
                    return str.length() > 3;
                })
                .forEach(str -> System.out.println("forEach loop: " + str));
    }

    private void goodOrder() {
        List<String> data = TestData.fewTestStringData();

        data.stream()
                .filter(str -> {
                    System.out.println("Filter element: " + str);
                    return str.length() > 3;
                })
                .map(str -> {
                    System.out.println("Map element: " + str);
                    return str;
                })
                .sorted((a, b) -> {
                    System.out.println("Sort element, compare " + a + " to " + b);
                    return a.compareTo(b);
                })
                .forEach(str -> System.out.println("forEach loop: " + str));
    }


    private void start() {
        wrongOrder();
        printSeparator();
        goodOrder();
    }

    public static void main(String[] args) {
        StreamExecutionOrder streamExecutionOrder = new StreamExecutionOrder();
        streamExecutionOrder.start();
    }


}
