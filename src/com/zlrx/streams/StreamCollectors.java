package com.zlrx.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectors {

    public static void main(String[] args) {
        StreamCollectors streamCollectors = new StreamCollectors();
        streamCollectors.grouping();
    }

    private void grouping() {
        List<Car> cars = carsGenerator();
        Map<Integer, List<Car>> carsMappedByYear = cars.stream().collect(Collectors.groupingBy(car -> car.year));
        System.out.println(carsMappedByYear);
    }


    private List<Car> carsGenerator() {
        List<Car> cars = new ArrayList<>(10);
        cars.add(new Car("Audi", 2015));
        cars.add(new Car("Ford", 2011));
        cars.add(new Car("Wolksvagen", 2015));
        cars.add(new Car("Bmw", 2013));
        cars.add(new Car("Lada", 1999));
        cars.add(new Car("Opel", 2015));
        cars.add(new Car("Seat", 2013));
        cars.add(new Car("Lamorghini", 2017));
        cars.add(new Car("Trabant", 2008));
        cars.add(new Car("Mercedes", 2011));
        return cars;
    }

    class Car {
        String name;
        public Integer year;

        public Car(String name, Integer year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return String.format("%s márkájú autó, melyet %d-ben gyártottak", name, year);
        }
    }


}
