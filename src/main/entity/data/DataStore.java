package main.entity.data;

import main.entity.builder.PersonBuilder;
import main.entity.Child;
import main.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private Map<String, Person> personMap = new HashMap<>();

    private static DataStore instance = new DataStore();
    public static DataStore getInstance(){
        return instance;
    }

    private DataStore(){
        //dummy data

        //Person 1
        personMap.put("1111",new PersonBuilder()
                .setSocialNumber("1111")
                .setName("Andrew")
                .build());

        //Person 2
        Map<Integer, Child> childrenMapMapP1 = new HashMap<>();
        childrenMapMapP1.put(1,new Child("C1",10,"2222"));
        childrenMapMapP1.put(2,new Child("C2",12,"2222"));
        personMap.put("2222",new PersonBuilder()
                .setSocialNumber("2222")
                .setName("Ross")
                .setChildrenData(childrenMapMapP1)
                .setSpouseData("Rachel")
                .build());

        Map<Integer, Child> childrenMapMapP2 = new HashMap<>();
        childrenMapMapP1.put(1,new Child("C3",8,"3333"));
        childrenMapMapP1.put(2,new Child("C4",12,"3333"));
        childrenMapMapP1.put(3,new Child("C5",13,"3333"));
        personMap.put("3333",new PersonBuilder()
                .setSocialNumber("3333")
                .setName("Chandler")
                .setChildrenData(childrenMapMapP1)
                .setSpouseData("Monica")
                .build());

    }

    public Person getPerson(String socialNo) {
        return personMap.get(socialNo);
    }

    public void createPerson(Person person) {
        personMap.put(person.getSocialNumber(), person);
    }

}
