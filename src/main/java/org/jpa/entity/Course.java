package org.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;


    /*
     * Unidirectional course and course_material relationship
     * a new foreign key column course_material_id will be created in course table
     * Course is the owner of the relationship and the parent entity
     * */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_material_id", referencedColumnName = "id")
    private CourseMaterial courseMaterial;


    /*
     * Unidirectional teacher and course relationship
     * a new foreign key column teacher_id will be created in course table
     * Course is the owner of the relationship and the parent entity
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    /*
    * Many to many relationship between course and students
    * A new table named course_student_mapping will be created to hold the relationship
    * Course is the owner of the relationship and the parent entity
    * */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student_mapping",
            joinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id") })
    private List<Student> students;
}
