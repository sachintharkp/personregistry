package main.entity.builder;

import main.entity.Child;
import main.entity.Person;

import java.util.Map;

public class PersonBuilder {
    private String socialNumber;

    private String name;

    private Map<Integer, Child> childrenData;

    private String spouseName;

    public PersonBuilder setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setChildrenData(Map<Integer, Child> childrenData) {
        this.childrenData = childrenData;
        return this;
    }

    public PersonBuilder setSpouseData(String spouseName) {
        this.spouseName = spouseName;
        return this;
    }

    public Person build(){
        return new Person(socialNumber,name,childrenData,spouseName);
    }

}
