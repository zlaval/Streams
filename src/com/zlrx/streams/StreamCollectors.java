package com.zlrx.streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectors {

    public static void main(String[] args) {
        StreamCollectors streamCollectors = new StreamCollectors();
        streamCollectors.start();
    }

    private void start() {
        groupingByYear();
        averageYear();
        carsToMap();
        partitioningByYear();
        ownCollector();
    }

    private void groupingByYear() {
        List<Car> cars = carsGenerator();
        Map<Integer, List<Car>> carsMappedByYear = cars.stream().collect(Collectors.groupingBy(car -> car.year));
        System.out.println(carsMappedByYear);
    }

    private void partitioningByYear() {
        List<Car> cars = carsGenerator();
        Map<Boolean, List<Car>> carsPartitionedByYear =
                cars.stream().collect(Collectors.partitioningBy(car -> car.year > 2012));
        System.out.println(carsPartitionedByYear);
    }

    private void averageYear() {
        List<Car> cars = carsGenerator();
        Double averageYear = cars.stream().collect(Collectors.averagingInt(car -> car.year));
        System.out.println(averageYear);
    }

    private void carsToMap() {
        List<Car> cars = carsGenerator();
        Map<String, Integer> carNameYearMap = cars.stream().collect(Collectors.toMap(car -> car.name, car -> car.year));
        System.out.println(carNameYearMap);
    }

    private void ownCollector() {
        List<Car> cars = carsGenerator();

        List<Car> carsAfter2013 = cars.stream()
                .filter(car -> car.year > 2013)
                .collect(
                        LinkedList::new,
                        LinkedList::add,
                        LinkedList::addAll
                );

        System.out.println(carsAfter2013);
    }


    private List<Car> carsGenerator() {
        List<Car> cars = new ArrayList<>(10);
        cars.add(new Car("Audi", 2015));
        cars.add(new Car("Ford", 2011));
        cars.add(new Car("Volkswagen", 2015));
        cars.add(new Car("Bmw", 2013));
        cars.add(new Car("Lada", 1999));
        cars.add(new Car("Opel", 2015));
        cars.add(new Car("Seat", 2013));
        cars.add(new Car("Lamborghini", 2017));
        cars.add(new Car("Trabant", 2008));
        cars.add(new Car("Mercedes", 2011));
        return cars;
    }

    class Car {
        String name;
        Integer year;

        public Car(String name, Integer year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", name, year);
        }
    }


}
