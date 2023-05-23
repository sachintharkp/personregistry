package main.service;

import main.entity.data.DataStore;
import main.entity.Child;
import main.entity.Person;
import main.exception.NoChildRecordExistException;
import main.exception.PersonNotFoundException;
import main.exception.SocialNumberAlreadyExistException;
import main.exception.SocialNumberMandatoryException;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class PersonRegistryService {

    private static final Logger LOGGER = Logger.getLogger(PersonRegistryService.class.getSimpleName());


    /**
     * This function is for creating person with social security number and name as minimum params for the person object.
     *
     * @param person
     * @throws SocialNumberMandatoryException
     * @throws SocialNumberAlreadyExistException
     */
    public void createPerson(Person person) throws SocialNumberMandatoryException, SocialNumberAlreadyExistException {
        if (Objects.nonNull(person) && (person.getSocialNumber() != null && person.getName() != null)) {
            if ((DataStore.getInstance().getPerson(person.getSocialNumber())) == null) {
                DataStore.getInstance().createPerson(person);
            } else {
                throw new SocialNumberAlreadyExistException("Social Security Number Already Exist.");
            }
        } else {
            throw new SocialNumberMandatoryException("Social Security Number and Name are mandatory to create Person");
        }

        LOGGER.info("User successfully created");

    }

    /**
     * This function used to get Person details by providing Social security number.
     *
     * @param socialNo
     * @return
     * @throws SocialNumberMandatoryException
     * @throws PersonNotFoundException
     */
    public Person getPerson(String socialNo) throws SocialNumberMandatoryException, PersonNotFoundException {

        if (!socialNo.isEmpty()) {
            Person person = DataStore.getInstance().getPerson(socialNo);
            if (!Objects.nonNull(person)) {
                throw new PersonNotFoundException("There is no person available with given social Number : " + socialNo);
            } else {
                LOGGER.info("User successfully found");
                return person;
               }
        } else {
            throw new SocialNumberMandatoryException("Social Security Number is mandatory to Search Person");
        }

    }

    /**
     * This function provide the oldest child details when provide social security number of a given person.
     *
     * @param socialNo
     * @return
     * @throws PersonNotFoundException
     * @throws SocialNumberMandatoryException
     */
    public Child getOldestChild(String socialNo) throws PersonNotFoundException, SocialNumberMandatoryException, NoChildRecordExistException {
        if (!socialNo.isEmpty()) {
            Person person = DataStore.getInstance().getPerson(socialNo);
            if (!Objects.nonNull(person)) {
                throw new PersonNotFoundException("There is no person available with given social Number : " + socialNo);
            } else {
                Map<Integer, Child> childrenMap = person.getChildrenData();
                if (childrenMap != null) {
                    Child child = childrenMap.values().stream()
                            .max((x, y) -> Integer.compare(x.getAge(), y.getAge()))
                            .get();
                    LOGGER.info("Oldest child successfully found");
                    return child;
                }
                else {
                    throw new NoChildRecordExistException("No child records available for this person,");
                }
            }
        } else {
            throw new SocialNumberMandatoryException("Social Security Number is mandatory to Search Person");

        }

    }
}