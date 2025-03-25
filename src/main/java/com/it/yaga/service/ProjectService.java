package com.it.yaga.service;

import com.it.yaga.dto.ProjectDTO;
import com.it.yaga.model.Project;
import org.springframework.data.domain.Page;

public interface ProjectService {
    Page<Project> searchProjects(String projectNm, int page, int size);
    Page<Project> searchProjects(String projectNm, Long deptId, Character difficulty, int page, int size);

    ProjectDTO convertEntityToDto(Project project);
}