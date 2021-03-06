package com.zlrx.streams;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.zlrx.streams.TestData.printSeparator;

public class ParallelStream {

    private void numberOfThreadInForkJoinPool() {
        System.out.println(ForkJoinPool.commonPool().getParallelism());
    }

    private void basicParallelExample() {
        TestData.fewTestStringData().parallelStream().map(String::toUpperCase).forEach(System.out::println);
    }

    private void parallelSpeedTest() {
        List<String> randomStrings = IntStream.range(1, 1_000_000)
                .boxed()
                .map(i -> UUID.randomUUID().toString())
                .collect(Collectors.toList());

        long streamStartTime = System.nanoTime();
        randomStrings.stream().sorted().collect(Collectors.toList());
        long streamEndTime = System.nanoTime();

        long ms = TimeUnit.NANOSECONDS.toMillis(streamEndTime - streamStartTime);
        System.out.printf("Stream rendezés időtartam: %d ms\n", ms);

        printSeparator();

        long parallelStreamStartTime = System.nanoTime();
        randomStrings.parallelStream().sorted().collect(Collectors.toList());
        long parallelStreamEndTime = System.nanoTime();

        long pms = TimeUnit.NANOSECONDS.toMillis(parallelStreamEndTime - parallelStreamStartTime);
        System.out.println(String.format("Parallelstream rendezés időtartam: %d ms", pms));
    }

    private void parallelStreamThreads() {
        Arrays.asList("1", "2", "3", "4", "5", "6", "7").parallelStream()
                .map(s -> {
                    System.out.println("Map     " + s + " value in thread: " + Thread.currentThread().getName());
                    return s;
                })
                .forEach(s -> System.out.println("Foreach " + s + " value in thread: " + Thread.currentThread().getName()));
    }

    private void start() {
        numberOfThreadInForkJoinPool();
        printSeparator();
        basicParallelExample();
        printSeparator();
        parallelSpeedTest();
        printSeparator();
        parallelStreamThreads();
    }

    public static void main(String[] args) {
        ParallelStream parallelStream = new ParallelStream();
        parallelStream.start();
    }


}
