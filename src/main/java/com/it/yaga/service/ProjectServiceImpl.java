package com.it.yaga.service;

import com.it.yaga.dto.ProjectDTO;
import com.it.yaga.model.Project;
import com.it.yaga.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Page<Project> searchProjects(String projectNm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.findByProjectNmContaining(projectNm, pageable);
    }

    @Override
    public Page<Project> searchProjects(String projectNm, Long deptId, Character difficulty, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.searchProjects(projectNm, deptId, difficulty, pageable);
    }

    public ProjectDTO convertEntityToDto(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(project.getProjectId());
        projectDTO.setProjectNm(project.getProjectNm());
        projectDTO.setDifficulty(project.getDifficulty());
        projectDTO.setDeptNm(project.getDept().getDeptNm());
        projectDTO.setVersion(project.getVersion());
        projectDTO.setInsTm(project.getInsTm());
        projectDTO.setUpdTm(project.getUpdTm());
        return projectDTO;
    }
}