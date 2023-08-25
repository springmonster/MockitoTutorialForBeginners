package com.privatefield;

public class MockService {

    private final Person person = new Person("John");

    public String getName() {
        return person.getName();
    }
}
