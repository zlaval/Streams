package com.zlrx.streams;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

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

        System.out.println("=================================");

        long parallelStreamStartTime = System.nanoTime();
        randomStrings.parallelStream().sorted().collect(Collectors.toList());
        long parallelStreamEndTime = System.nanoTime();

        long pms = TimeUnit.NANOSECONDS.toMillis(parallelStreamEndTime - parallelStreamStartTime);
        System.out.println(String.format("Parallelstream rendezés időtartam: %d ms", pms));
    }


    private void start() {
        parallelSpeedTest();
    }

    public static void main(String[] args) {
        ParallelStream parallelStream = new ParallelStream();
        parallelStream.start();
    }


}
