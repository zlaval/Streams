package com.zlrx.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OldStyleVsStream {

    private void oldStyleListFilter() {
        List<Integer> filterable = getIntegers();
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : filterable) {
            if (element % 2 == 0) {
                filtered.add(element);
            }
        }
        System.out.println(filtered);
    }

    private void streamListFilter() {
        List<Integer> filterable = getIntegers();
        List<Integer> filtered = filterable.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }


    private List<Integer> getIntegers() {
        return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        OldStyleVsStream oldStyleVsStream = new OldStyleVsStream();
        oldStyleVsStream.oldStyleListFilter();
        oldStyleVsStream.streamListFilter();
    }
}
