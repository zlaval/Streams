package com.zlrx.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreams {


    private void numericStreams() {
        IntSummaryStatistics statistics = IntStream.of(1, 3, 5, 7, 9).summaryStatistics();
        System.out.println(statistics);

        DoubleStream.of(2.4, 3.7).summaryStatistics();
    }


    private void start() {
        numericStreams();
    }

    public static void main(String[] args) {
        NumericStreams numericStreams = new NumericStreams();
        numericStreams.start();
    }


}
