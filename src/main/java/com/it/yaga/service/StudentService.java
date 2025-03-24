package com.it.yaga.service;

import com.it.yaga.model.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<Student> getPaginatedStudents(int page, int size);
}