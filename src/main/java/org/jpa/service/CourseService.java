package org.jpa.service;

import jakarta.transaction.Transactional;
import org.jpa.entity.Course;
import org.jpa.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> findAllCourses() {
        return courseRepo.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> saveAllCourse(List<Course> courses) {
        return courseRepo.saveAll(courses);
    }

    public Course updateCourse(Course course) {
        course.setName(course.getName() +"_updated");
        return courseRepo.save(course);
    }

    public void deleteCourse(Course course) {
        courseRepo.delete(course);
    }

    public void deleteById(int courseId) {
        courseRepo.deleteById(courseId);
    }
}
