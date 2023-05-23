package test;


import main.entity.builder.PersonBuilder;
import main.entity.Child;
import main.entity.Person;
import main.exception.NoChildRecordExistException;
import main.exception.PersonNotFoundException;
import main.exception.SocialNumberAlreadyExistException;
import main.exception.SocialNumberMandatoryException;
import main.service.PersonRegistryService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PersonRegistryServiceTest {

    public static final String SOCIAL_NUMBER_P1 = "1111";
    public static final String SOCIAL_NUMBER_P2 = "5555";

    public static final String SOCIAL_NUMBER_P5 = "3333";
    public static final String SOCIAL_NUMBER_INVALID = "1221";

    public static final String SOCIAL_NUMBER_DUPLICATE = "2222";
    public static final String OLDEST_CHILD_NAME = "C5";
    public static final String PERSON3_NAME = "Sachintha";
    public static final String PERSON2_CHILD1_NAME = "C1";
    public static final String PERSON2_CHILD2_NAME = "C2";
    public static final String PERSON2_NAME = "Robert";
    public static final String PERSON2_SPOUSE_NAME = "Sofia";
    public static final String PERSON1 = "Andrew";
    private PersonRegistryService registryService;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;

    @Before
    public void setUp() {
        registryService = new PersonRegistryService();
        person1 = new PersonBuilder().setSocialNumber(SOCIAL_NUMBER_P1).setName(PERSON1).build();

        Map<Integer, Child> childrenMapMapP2 = new HashMap<>();
        childrenMapMapP2.put(1,new Child(PERSON2_CHILD1_NAME,10,SOCIAL_NUMBER_P2));
        childrenMapMapP2.put(2,new Child(PERSON2_CHILD2_NAME,12,SOCIAL_NUMBER_P2));
        person2 = new PersonBuilder().setSocialNumber(SOCIAL_NUMBER_P2).setName(PERSON2_NAME).setSpouseData(PERSON2_SPOUSE_NAME).setChildrenData(childrenMapMapP2).build();

        person3 = new PersonBuilder().setSocialNumber(SOCIAL_NUMBER_DUPLICATE).setName(PERSON3_NAME).build();

    }
    @Test
    public void testGetPersonNotFound() throws SocialNumberMandatoryException, PersonNotFoundException {
        assertEquals(person1.getSocialNumber(), registryService.getPerson(SOCIAL_NUMBER_P1).getSocialNumber());
        assertEquals(person1.getName(), registryService.getPerson(SOCIAL_NUMBER_P1).getName());
    }

    @Test(expected = PersonNotFoundException.class)
    public void testGetPerson() throws SocialNumberMandatoryException, PersonNotFoundException {
        registryService.getPerson(SOCIAL_NUMBER_INVALID);
    }
    @Test
    public void testCreatePerson() throws SocialNumberMandatoryException, SocialNumberAlreadyExistException, PersonNotFoundException {
        registryService.createPerson(person2);
        assertEquals(person2.getSocialNumber(), SOCIAL_NUMBER_P2);
        assertEquals(person2.getName(), registryService.getPerson(SOCIAL_NUMBER_P2).getName());
        assertEquals(person2.getSpouseName(), registryService.getPerson(SOCIAL_NUMBER_P2).getSpouseName());
        assertEquals(2,registryService.getPerson(SOCIAL_NUMBER_P2).getChildrenData().size());
    }

    @Test(expected = SocialNumberAlreadyExistException.class)
    public void testCreatePersonDuplicateSocialNo() throws SocialNumberMandatoryException, SocialNumberAlreadyExistException{
        registryService.createPerson(person3);
    }

    @Test(expected = SocialNumberMandatoryException.class)
    public void testCreatePersonEmptySocialNo() throws SocialNumberMandatoryException, SocialNumberAlreadyExistException {
        registryService.createPerson(person4);
    }

    @Test
    public void testGetOldestChild() throws SocialNumberMandatoryException, PersonNotFoundException, NoChildRecordExistException {
        Child child = registryService.getOldestChild(SOCIAL_NUMBER_P5);
        assertEquals(OLDEST_CHILD_NAME,child.getName());
    }

    @Test(expected = NoChildRecordExistException.class)
    public void testGetOldestChildWhenNoChild() throws SocialNumberMandatoryException, PersonNotFoundException, NoChildRecordExistException {
        Child child = registryService.getOldestChild(SOCIAL_NUMBER_P1);
        assertEquals(OLDEST_CHILD_NAME,child.getName());
    }

}
