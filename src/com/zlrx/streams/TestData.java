package com.zlrx.streams;

import java.util.ArrayList;
import java.util.List;

public final class TestData {

    private TestData() {

    }


    public static List<String> testStringData() {
        List<String> strings = new ArrayList<>();
        strings.add("foo");
        strings.add("bar");
        strings.add("home");
        strings.add("sworld");
        strings.add("play");
        strings.add("animal");
        strings.add("sworld");
        strings.add("car");
        strings.add("sun");
        strings.add("java");
        return strings;
    }

    public static List<String> fewTestStringData() {
        List<String> strings = new ArrayList<>();
        strings.add("sworld");
        strings.add("animal");
        strings.add("sun");
        strings.add("java");
        return strings;
    }

    public static void printSeparator() {
        System.out.println("====================================");
    }


}
