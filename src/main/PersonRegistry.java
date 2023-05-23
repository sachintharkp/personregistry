package main;

import main.entity.builder.PersonBuilder;
import main.entity.Child;
import main.entity.Person;
import main.exception.NoChildRecordExistException;
import main.exception.PersonNotFoundException;
import main.exception.SocialNumberAlreadyExistException;
import main.exception.SocialNumberMandatoryException;
import main.service.PersonRegistryService;

import java.util.HashMap;
import java.util.Map;

public class PersonRegistry {
    public static final String SOCIAL_NUMBER = "5555";

    public static void main(String[] args) throws SocialNumberMandatoryException, SocialNumberAlreadyExistException,
            PersonNotFoundException, NoChildRecordExistException {

        PersonRegistryService registryService = new PersonRegistryService();

        Map<Integer, Child> childrenMapMapP2 = new HashMap<>();
        childrenMapMapP2.put(1, new Child("C1", 10, SOCIAL_NUMBER));
        childrenMapMapP2.put(2, new Child("C2", 12, SOCIAL_NUMBER));
        Person person = new PersonBuilder().setSocialNumber(SOCIAL_NUMBER).setName("Robert").setSpouseData("Sofia")
                .setChildrenData(childrenMapMapP2).build();

        registryService.createPerson(person);

        registryService.getPerson(SOCIAL_NUMBER);

        registryService.getOldestChild(SOCIAL_NUMBER);
    }
}
