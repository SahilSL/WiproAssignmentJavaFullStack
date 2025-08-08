package com.wipro.person;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDAO dao = context.getBean(PersonDAO.class);

        System.out.println("List of person is:");
        dao.getAllPersons().forEach(System.out::println);

        System.out.println("\nGet person with ID 102");
        Person person = dao.getPersonById(102);
        if (person != null) System.out.println(person);

        System.out.println("\nCreating person:");
        dao.createPerson(new Person(105, 29, "Priya", "Kumar"));
        dao.getAllPersons().forEach(System.out::println);

        System.out.println("\nDeleting person with ID 103");
        dao.deletePerson(103);
        dao.getAllPersons().forEach(System.out::println);

        System.out.println("\nUpdating person with ID 105");
        dao.updatePerson(new Person(105, 29, "Priya", "CHANGED"));
        dao.getAllPersons().forEach(System.out::println);

        context.close();
    }
}

/*List of person is:
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
Person{id=101, age=24, firstName='Sahil', lastName='Lokhande'}
Person{id=103, age=24, firstName='Ariella', lastName='Guzman'}
Person{id=104, age=36, firstName='Rohit', lastName='Sharma'}

Get person with ID 102
No person found with ID 102

Creating person:
Person{id=101, age=24, firstName='Sahil', lastName='Lokhande'}
Person{id=103, age=24, firstName='Ariella', lastName='Guzman'}
Person{id=104, age=36, firstName='Rohit', lastName='Sharma'}
Person{id=105, age=29, firstName='Priya', lastName='Kumar'}

Deleting person with ID 103
Person{id=101, age=24, firstName='Sahil', lastName='Lokhande'}
Person{id=104, age=36, firstName='Rohit', lastName='Sharma'}
Person{id=105, age=29, firstName='Priya', lastName='Kumar'}

Updating person with ID 105
Person{id=101, age=24, firstName='Sahil', lastName='Lokhande'}
Person{id=104, age=36, firstName='Rohit', lastName='Sharma'}
Person{id=105, age=29, firstName='Priya', lastName='CHANGED'}
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown initiated...
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown completed.
*/