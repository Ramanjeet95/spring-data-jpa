package org.jpa.service;

import org.jpa.repository.TeacherRepo;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
}
