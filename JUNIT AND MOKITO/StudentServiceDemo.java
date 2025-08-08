package com.example.junit;
/*4.Scenario: You have a StudentService that uses StudentRepository.
Mock StudentRepository
When findById(1) is called, return a dummy Student
Verify if StudentService.getStudentById(1) returns the expected name*/
// All logic in one file
public class StudentServiceDemo {

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
    }

    public interface StudentRepository {
        Student findById(int id);
    }

    public static class StudentService {
        private StudentRepository repository;

        public StudentService(StudentRepository repository) {
            this.repository = repository;
        }

        public String getStudentById(int id) {
            Student student = repository.findById(id);
            return (student != null) ? student.getName() : null;
        }
    }
}
