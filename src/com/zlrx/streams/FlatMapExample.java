package com.zlrx.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

    public static void main(String[] args) {
        FlatMapExample flatMapExample = new FlatMapExample();
        flatMapExample.listAllPhoneNumber();
    }

    private void listAllPhoneNumber() {
        List<Person> people = people();
        people.stream()
                .flatMap(person -> person.phoneNumbers.stream())
                .forEach(System.out::println);
    }

    private List<Person> people() {
        List<Person> people = new ArrayList<>();
        people.add(createPerson("Aladár", "123456", "234567"));
        people.add(createPerson("Cecil", "312897", "564684", "658416", "268965"));
        people.add(createPerson("Dezső"));
        people.add(createPerson("Béla", "762391"));
        people.add(createPerson("Elemér", "657413"));
        people.add(createPerson("Flóra", "548746", "548564"));
        return people;
    }

    private Person createPerson(String name, String... phonNumbers) {
        Person person = new Person();
        person.name = name;
        person.phoneNumbers = Arrays.asList(phonNumbers);
        return person;
    }

    class Person {
        String name;
        List<String> phoneNumbers;
    }

}
