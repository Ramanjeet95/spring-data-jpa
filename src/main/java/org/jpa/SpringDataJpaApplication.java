package org.jpa;

import org.jpa.entity.*;
import org.jpa.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    private final CourseService courseService;

    public SpringDataJpaApplication(CourseService courseService) {
        this.courseService = courseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner createData() {

        CourseMaterial courseMaterial1 = CourseMaterial.builder().description("Course for DSA").build();
        CourseMaterial courseMaterial2 = CourseMaterial.builder().description("Course for Python").build();

        Address address1 = new Address("Noida", "UP", "India", "12345");
        Teacher teacher1 = Teacher.builder().name("Akash").address(address1).build();


        Address address2 = new Address("Jalandher", "Punjab", "India", "45678");
        Address address3 = new Address("New York", "New York", "USA", "00011");
        Address address4 = new Address("Noida", "UP", "India", "12345");
        Address address5 = new Address("Amritsar", "Punjab", "India", "67345");

        Student student1 = Student.builder().name("Raman").rollNo("1").address(address2).build();
        Student student2 = Student.builder().name("William").rollNo("2").address(address3).build();

        Student student3 = Student.builder().name("Tarun").rollNo("3").address(address4).build();

        Teacher teacher2 = Teacher.builder().name("Dibjot").address(address5).build();

        Course course1 = Course.builder()
                .name("DSA")
                .courseMaterial(courseMaterial1)
                .teacher(teacher1)
                .students(List.of(student1, student2))
                .build();

        Course course2 = Course.builder()
                .name("Python")
                .courseMaterial(courseMaterial2)
                .teacher(teacher2)
                .students(List.of(student1, student3))
                .build();

        return args -> courseService.saveAllCourse(List.of(course1, course2));
    }
}
