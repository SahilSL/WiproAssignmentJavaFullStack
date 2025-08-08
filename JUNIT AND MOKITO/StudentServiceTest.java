package com.example.junit;
/*4.Scenario: You have a StudentService that uses StudentRepository.
Mock StudentRepository
When findById(1) is called, return a dummy Student
Verify if StudentService.getStudentById(1) returns the expected name*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    @Test
    public void testGetStudentById_ReturnsExpectedName() {
        //Mock the repository
        StudentServiceDemo.StudentRepository mockRepo = mock(StudentServiceDemo.StudentRepository.class);

        //Dummy student
        StudentServiceDemo.Student dummyStudent = new StudentServiceDemo.Student(1, "Sahil");

        //Setup mock
        when(mockRepo.findById(1)).thenReturn(dummyStudent);

        //Inject mock
        StudentServiceDemo.StudentService service = new StudentServiceDemo.StudentService(mockRepo);

        String name = service.getStudentById(1);
        System.out.println("Name = " + name);  // for debug

        assertEquals("Sid", name);

        verify(mockRepo).findById(1);
    }
}
