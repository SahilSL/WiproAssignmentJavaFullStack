package com.wipro.person;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM person",
                (rs, rowNum) -> new Person(
                        rs.getInt("id"),
                        rs.getInt("age"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
    }

    @Override
    public Person getPersonById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?",
                    (rs, rowNum) -> new Person(
                            rs.getInt("id"),
                            rs.getInt("age"),
                            rs.getString("first_name"),
                            rs.getString("last_name")),
                    id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No person found with ID " + id);
            return null;
        }
    }

    @Override
    public void createPerson(Person person) {
        jdbcTemplate.update("INSERT INTO person (id, age, first_name, last_name) VALUES (?, ?, ?, ?)",
                person.getId(), person.getAge(), person.getFirstName(), person.getLastName());
    }

    @Override
    public void deletePerson(int id) {
        int rows = jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
        if (rows == 0) {
            System.out.println("No person found with ID " + id + " to delete.");
        }
    }

    @Override
    public void updatePerson(Person person) {
        int rows = jdbcTemplate.update("UPDATE person SET age=?, first_name=?, last_name=? WHERE id=?",
                person.getAge(), person.getFirstName(), person.getLastName(), person.getId());
        if (rows == 0) {
            System.out.println("No person found with ID " + person.getId() + " to update.");
        }
    }
}
