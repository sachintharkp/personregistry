package main.entity;

import java.util.Map;

public class Person {

    private String socialNumber;

    private String name;

    private Map<Integer, Child> childrenData;

    private String spouseName;

    public Person(String socialNumber, String name, Map<Integer, Child> childrenData, String spouseName) {
        this.socialNumber = socialNumber;
        this.name = name;
        this.childrenData = childrenData;
        this.spouseName = spouseName;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Child> getChildrenData() {
        return childrenData;
    }

    public String getSpouseName() {
        return spouseName;
    }
}
