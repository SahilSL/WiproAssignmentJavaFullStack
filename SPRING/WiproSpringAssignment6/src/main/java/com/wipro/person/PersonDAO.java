package com.wipro.person;
import java.util.List;

public interface PersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(int id);
    void createPerson(Person person);
    void deletePerson(int id);
    void updatePerson(Person person);
}
