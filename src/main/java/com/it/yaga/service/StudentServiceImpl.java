package com.it.yaga.service;

import com.it.yaga.model.Student;
import com.it.yaga.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> getPaginatedStudents(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }
}