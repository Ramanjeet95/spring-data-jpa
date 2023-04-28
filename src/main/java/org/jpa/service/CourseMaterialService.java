package org.jpa.service;

import org.jpa.repository.CourseMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialService {
    private final CourseMaterialRepo courseMaterialRepo;

    @Autowired
    public CourseMaterialService(CourseMaterialRepo courseMaterialRepo) {
        this.courseMaterialRepo = courseMaterialRepo;
    }


}
