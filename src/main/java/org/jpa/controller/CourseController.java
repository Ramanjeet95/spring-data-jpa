package org.jpa.controller;

import org.jpa.entity.Course;
import org.jpa.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> fetchAllCourses() {
        return courseService.findAllCourses();
    }
}
